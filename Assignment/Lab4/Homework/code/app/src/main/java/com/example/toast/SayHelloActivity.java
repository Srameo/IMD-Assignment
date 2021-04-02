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