# Lab5. Homework

- [Lab5. Homework](#lab5-homework)
  - [ScreenShot](#screenshot)
  - [Video](#video)
  - [Code](#code)
    - [`AndroidManifest.xml`](#androidmanifestxml)
    - [`MainActivity.java`](#mainactivityjava)
    - [`Strings.xml`](#stringsxml)
    - [`activity_main.xml`](#activity_mainxml)

## ScreenShot

1. Layout

<img src="../../../asset/Lab5/Practice/Layout.png" alt="layout" style="zoom:25%;" />

2. Click take a pic

<img src="../../../asset/Lab5/Homework/click_take_a_pic.png" alt="image-20210410180715619" style="zoom:25%;" />

## Video

[Video Link](../Lab5.mov)

## Code

### `AndroidManifest.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.implicitintents">

<!--    for api 30 -->
<!--    <uses-permission android:name="android.permission.CAMERA" />-->
<!--    <uses-feature android:name="android.hardware.camera"-->
<!--        android:required="true" />-->

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.ImplicitIntents">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

<!--    for api 30 -->
<!--    <queries>-->
<!--        <intent>-->
<!--            <action android:name="android.intent.action.VIEW" />-->
<!--            <data android:scheme="geo" />-->
<!--        </intent>-->
<!--        <intent>-->
<!--            <action android:name="android.intent.action.VIEW" />-->
<!--            <data android:scheme="https" />-->
<!--        </intent>-->
<!--    </queries>-->

</manifest>
```

### `MainActivity.java`

```java
package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.widget.ImageViewCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);  // 将 url 编码成 Uri 对象
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        Log.d("ImplicitIntents", "url: " + url);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this! - openWebsite");
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent! - openLocation");
        }
    }

    public void shareText(View view) {
        String txt = mShareEditText.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)                                     // The Activity that launches this share Intent (this).
                .setType(mimeType)                              // The MIME type of the item to be shared.
                .setChooserTitle("Share this text with: ")      // The title that appears on the system app chooser.
                .setText(txt)                                   // The actual text to be shared
                .startChooser();                                // Show the system app chooser and send the Intent.
    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(takePictureIntent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent! - takePicture");
        }
    }
}
```

### `Strings.xml`

```xml
<resources>
    <string name="app_name">ImplicitIntents</string>
    <string name="edittext_uri">http://developer.android.com</string>
    <string name="button_uri">Open Website</string>
    <string name="edittext_loc">Golden Gate Bridge</string>
    <string name="button_loc">Open Location</string>
    <string name="edittext_share">\'Twas brillig and the slithy toves</string>
    <string name="button_share">Share This Text</string>
    <string name="button_take_pic">Take a Picture</string>
</resources>
```

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/website_edittext"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/edittext_uri" />

    <Button
        android:id="@+id/open_website_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="24dp"
        android:text="@string/button_uri"
        android:onClick="openWebsite"/>

    <EditText
        android:id="@+id/location_edittext"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/edittext_loc" />

    <Button
        android:id="@+id/open_location_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="24dp"
        android:text="@string/button_loc"
        android:onClick="openLocation" />

    <EditText
        android:id="@+id/share_edittext"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/edittext_share" />

    <Button
        android:id="@+id/share_text_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="24dp"
        android:text="@string/button_share"
        android:onClick="shareText" />

    <Button
        android:id="@+id/take_pic_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/button_take_pic"
        android:onClick="takePicture" />

</LinearLayout>
```

