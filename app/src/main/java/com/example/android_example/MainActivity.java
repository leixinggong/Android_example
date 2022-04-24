package com.example.android_example;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button contextBtn;
    private Button popUpMenu;
    private Button nextBtn;
    private Button nextDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        addTargetClick();
    }

    private void findViews() {
        contextBtn = findViewById(R.id.contextBtn);
        popUpMenu = findViewById(R.id.popup_memu);
        nextBtn = findViewById(R.id.next);
    }

    private void addTargetClick() {
        registerForContextMenu(contextBtn);
        contextBtn.setOnLongClickListener(view -> {
            openContextMenu(view);
            return true;
        });


        /// PopUpMenu
        contextBtn.setOnCreateContextMenuListener(this);
        contextBtn.setOnClickListener(View::showContextMenu);
        popUpMenu.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(this,view);
            popupMenu.getMenuInflater().inflate(R.menu.context_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
            popupMenu.show();
        });

        /// 下一页
        nextBtn.setText(R.string.dialog);
        nextBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,DialogActivity.class);
            intent = new Intent("android.intent.action.ACTION_START");
            startActivity(intent);
        });


        nextDialog = findViewById(R.id.nextDialog);
        nextDialog.setOnClickListener(view -> {
            Intent intent = new Intent(this, LifecycleActivity.class);
            startActivityForResult(intent, 1);

//            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), o -> {
//            });
        });
    }


    ///🐶 OptionsMemu
    /**
     * 重载实现右上角的菜单
     *
     * @param menu 菜单实例
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
            case R.id.remove_itme:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item1:
            case R.id.item2:
                Toast.makeText(this, "subItem " + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }



    ///🐶 ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }


    /// PopUpMenu
}