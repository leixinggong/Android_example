package com.example.android_example;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private Button dialogBtn;
    private Button customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViews();
    }


    private void findViews() {
        dialogBtn = findViewById(R.id.dialog);
        dialogBtn.setOnClickListener(view -> {
            showSystemDialog();
        });

        customDialog = findViewById(R.id.custom_dialog);
        customDialog.setOnClickListener(view -> {
            CustomDialog customDialog = new CustomDialog(this,R.style.custom_dialog);
            customDialog.show();
        });
    }


    private void showSystemDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(DialogActivity.this);
        alert.setTitle("你好啊!")
                .setMessage("李银河啊")
                .setPositiveButton("确定", (dialogInterface , id) -> {

                });
        alert.setNegativeButton("取消", (dialogInterface, i) -> {
            Toast.makeText(this, "cancel dialog", Toast.LENGTH_SHORT).show();
        });
        alert.show();
    }
}