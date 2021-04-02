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