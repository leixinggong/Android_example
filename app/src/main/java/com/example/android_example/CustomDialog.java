package com.example.android_example;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog {

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.dialog_layout);
    }
}
