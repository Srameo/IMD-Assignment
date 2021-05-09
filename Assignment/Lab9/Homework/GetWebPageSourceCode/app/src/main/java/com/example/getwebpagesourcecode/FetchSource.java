package com.example.getwebpagesourcecode;

import android.os.AsyncTask;
import android.widget.EditText;

import java.lang.ref.WeakReference;

public class FetchSource extends AsyncTask<String, Void, String> {

    WeakReference<EditText> mScrollViewRef;

    FetchSource(EditText scrollView) {
        mScrollViewRef = new WeakReference<>(scrollView);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetWorkUtils.getWebSource(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mScrollViewRef.get().setText(s);
    }
}
