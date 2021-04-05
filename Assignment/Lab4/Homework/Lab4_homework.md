# Lab4. Homework


- [Lab4. Homework](#lab4-homework)
  - [Screencut](#screencut)
  - [Video](#video)
  - [Code](#code)


## Screencut

1. MainActivity

![image-20210402205658561](../../../asset/Lab4/Practice/MainActivity_layout_homework.png)

2. ShowCountActivity

![image-20210402205742655](../../../asset/Lab4/Practice/MainActivity_layout_homework_showcount.png)

3. MainActivity - Not Zero

![image-20210402205823933](../../../asset/Lab4/Practice/MainActivity_layout_homework_not_0.png)

4. ShowCountActivity - Not Zero

![image-20210402205857774](../../../asset/Lab4/Practice/MainActivity_layout_homework_not_0_showcount.png)

## Video

[Video Link](./Lab4_homework.mov)

## Code

[code dir](./code)

### `MainActivity.Java`

```Java
package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 声明日志输出的 tag
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public static final String COUNT_MESSAGE = "com.example.toast.count.message";

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
        Log.d(LOG_TAG, "showToast clicked!");
        // homework1
//        Toast toast = Toast.makeText(this, R.string.toast_message,
//                Toast.LENGTH_SHORT);
//        toast.show();

        // homework2
        Intent intent = new Intent(this, SayHelloActivity.class);
        String countMessage = mShowCount.getText().toString();
        intent.putExtra(COUNT_MESSAGE, countMessage);
        startActivity(intent);
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
        Log.d(LOG_TAG, "countUp clicked!");
        // 增加 1
        ++mCount;
        setNumber();
    }

    public void setZero(View view) {
        Log.d(LOG_TAG, "setZero clicked!");
        // 设置为 0
        mCount = 0;
        setNumber();
    }
}
```

### `SayHelloActivity.Java`

```Java
package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SayHelloActivity extends AppCompatActivity {

    private TextView mShowCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello);
        Intent intent = getIntent();
        mShowCountTextView = findViewById(R.id.textView_show_count);
        String countMessage = intent.getStringExtra(MainActivity.COUNT_MESSAGE);
        mShowCountTextView.setText(countMessage);
    }
}
```

### `activity_say_hello.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SayHelloActivity">

    <TextView
        android:id="@+id/textView_say_hello"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/text_say_hello"
        android:textSize="50sp"
        app:layout_constraintBottom_toTopOf="@+id/textView_show_count"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView_show_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/text_default_show_count"
        android:textSize="50sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView_say_hello" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

