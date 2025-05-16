package maevskii.studio.loading_button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class LoadingButton extends LinearLayout {

    private ProgressBar progressBar;
    private TextView buttonTextView;
    private boolean isLoading = false;

    public LoadingButton(Context context) {
        super(context);
        init(context, null, 0);
    }

    public LoadingButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public LoadingButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View root = LayoutInflater.from(context).inflate(R.layout.button_loading, this, true);
        buttonTextView = root.findViewById(R.id.button_text);
        progressBar = root.findViewById(R.id.button_progress_bar);

        loadAttr(context, attrs, defStyleAttr);
    }

    private void loadAttr(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs == null) return;

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton, defStyleAttr, 0);

        setEnabled(true);
        buttonTextView.setEnabled(true);
        buttonTextView.setTextColor(arr.getColor(R.styleable.LoadingButton_android_textColor, Color.BLACK));

        int globalPadding = arr.getInteger(R.styleable.LoadingButton_android_padding, 0);
        this.setPadding(
                Math.max(globalPadding, arr.getInteger(R.styleable.LoadingButton_android_paddingStart, 0)),
                Math.max(globalPadding, arr.getInteger(R.styleable.LoadingButton_android_paddingTop, 0)),
                Math.max(globalPadding, arr.getInteger(R.styleable.LoadingButton_android_paddingEnd, 0)),
                Math.max(globalPadding, arr.getInteger(R.styleable.LoadingButton_android_paddingBottom, 0))
        );
        setText(arr.getString(R.styleable.LoadingButton_android_text));
        setBackgroundResource(R.drawable.button_background);
        setGravity(Gravity.CENTER);

        setLoading(arr.getBoolean(R.styleable.LoadingButton_isLoading, false));
        progressBar.getIndeterminateDrawable().setColorFilter(arr.getColor(R.styleable.LoadingButton_progressBarColor, Color.BLACK), PorterDuff.Mode.SRC_IN);

        arr.recycle();
    }

    public void setLoading(boolean loading) {
        setClickable(!loading); // Disable click when loading
        isLoading = loading;

        if (isLoading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setText(String text) {
        buttonTextView.setText(text);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        buttonTextView.setEnabled(enabled);
    }
}
