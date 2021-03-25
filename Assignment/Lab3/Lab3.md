# Lab 3. Hello Toast!

- [Lab 3. Hello Toast!](#lab-3-hello-toast)
  - [Program Screencut](#program-screencut)
    - [layout](#layout)
    - [Runtime ScreenShoot](#runtime-screenshoot)
  - [Video](#video)
  - [Code](#code)
    - [`MainActivity.Java`](#mainactivityjava)
    - [`colors.xml`](#colorsxml)
    - [`strings.xml`](#stringsxml)
    - [`ActivtiMain.xml`](#activtimainxml)
    - [`land/ActivtiMain.xml`](#landactivtimainxml)

## Program Screencut

### layout

![image-20210325110629375](../../asset/Lab3/layout.png)

![image-20210325110703794](../../asset/Lab3/land_layout.png)

### Runtime ScreenShoot

<img src="../../asset/Lab3/runtime_ss1.png" alt="image-20210325110816952" style="zoom:33%;" /><img src="../../asset/Lab3/runtime_ss2.png" alt="image-20210325110919467" style="zoom: 33%;" />

<img src="../../asset/Lab3/runtime_ss3.png" alt="image-20210325111019422" style="zoom:33%;" />

<img src="../../asset/Lab3/runtime_ss4.png" alt="image-20210325111046527" style="zoom:33%;" />



## Video

[video link](./lab3.mov)

## Code

### `MainActivity.Java`

```java
package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static private int mCount = 0;
    private TextView mShowCount;
    private Button zeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        zeroButton = (Button) findViewById(R.id.button_zero);
        setNumber();
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    private void setNumber() {
        // 通过数值来设置按钮和显示数字的颜色
        assert mShowCount != null;  // 保证 mShowCount 不会为 null
        mShowCount.setText(String.valueOf(mCount));
        if (mCount == 0) zeroButton.setBackgroundColor(getColor(R.color.gray));
        else zeroButton.setBackgroundColor(getColor(R.color.design_default_color_primary));
        if (mCount % 2 == 0) {
            mShowCount.setBackgroundColor(getColor(R.color.lightyellow));
            mShowCount.setTextColor(getColor(R.color.design_default_color_primary));
        }
        else {
            mShowCount.setBackgroundColor(getColor(R.color.lightpurple));
            mShowCount.setTextColor(getColor(R.color.white));
        }
    }

    public void countUp(View view) {
        // 增加 1
        ++mCount;
        setNumber();
    }

    public void setZero(View view) {
        // 设置为 0
        mCount = 0;
        setNumber();
    }
}
```

### `colors.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="purple_200">#FFBB86FC</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700B3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="gray">#B7B7B7</color>
    <color name="lightpurple">#FF00FF</color>
    <color name="lightyellow">#FFFF00</color>
</resources>
```

### `strings.xml`

```xml
<resources>
    <string name="app_name">Toast</string>
    <string name="button_label_toast">Toast</string>
    <string name="button_label_count">Count</string>
    <string name="button_label_zero">Zero</string>
    <string name="count_initial_value">0</string>
    <string name="toast_message">Hello Toast!</string>
</resources>
```

### `ActivtiMain.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button_toast"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:background="@color/design_default_color_primary"
        android:text="@string/button_label_toast"
        android:textColor="@android:color/white"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:onClick="showToast" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/design_default_color_primary"
        android:onClick="countUp"
        android:text="@string/button_label_count"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/button_zero"
        app:layout_constraintStart_toStartOf="parent" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/lightyellow"
        android:gravity="center"
        android:text="@string/count_initial_value"
        android:textAlignment="center"
        android:textColor="@color/design_default_color_primary"
        android:textSize="160sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/button_zero"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_toast" />

    <Button
        android:id="@+id/button_zero"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/design_default_color_primary"
        android:onClick="setZero"
        android:text="@string/button_label_zero"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.495"
        app:layout_constraintStart_toEndOf="@+id/button_count" />
</androidx.constraintlayout.widget.ConstraintLayout>
```



### `land/ActivtiMain.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button_toast"
        android:layout_width="100dp"
        android:layout_height="50dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/design_default_color_primary"
        android:onClick="showToast"
        android:text="@string/button_label_toast"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toTopOf="@+id/button_zero"
        app:layout_constraintEnd_toStartOf="@+id/show_count"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.513" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/design_default_color_primary"
        android:onClick="countUp"
        android:text="@string/button_label_count"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/show_count"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_zero" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/lightyellow"
        android:gravity="center"
        android:text="@string/count_initial_value"
        android:textAlignment="center"
        android:textColor="@color/design_default_color_primary"
        android:textSize="160sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/button_toast"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_zero"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        android:background="@color/design_default_color_primary"
        android:onClick="setZero"
        android:text="@string/button_label_zero"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toTopOf="@+id/button_count"
        app:layout_constraintEnd_toStartOf="@+id/show_count"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_toast" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

