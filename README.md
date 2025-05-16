# Loading Button UI component for Android

🚀 LoadingButton is a customizable Android button built with Java and XML that includes a built-in progress indicator. 

✅ It can help you to easily display a loading spinner directly inside the button - perfect for login screens, forms or any other async task. 

## Installation

1. Add `jitpack.io` to your project's `settings.gradle` file:
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

2. Add library to your module's `build.gradle` file:
```
dependencies {
  implementation("com.github.memaev:LoadingButton:v1.0.1")
}
```
3. Click "Sync now" to sync the project. If the sync passed successfully - you're done with the installation!

## How to use
1. Add button to your XML:
```
<maevskii.studio.loading_button.LoadingButton
        android:id="@+id/btn_loading"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:isLoading="true"
        android:text="Hello World!"
        app:progressBarColor="@color/white" 
        android:textColor="@color/white"
        />
```
`app:brogressBarColor` - to declare the color of the progress bar inside your button
`app:isLoading` - to declare by default the status of the button. true - progress bar is shown, false - progress bar is hidden.

2. Change the loading status of the button programmatically from your Java/Kotlin code
```
LoadingButton loadingButton = findViewById(R.id.btn_loading);
loadingButton.setLoading(true);
// long loading task
loadingButton.setLoading(false);
```
