package com.example.bottomnavtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class CustomPopup extends AppCompatActivity {

    public EditText newCollectionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.575), (int)(height*0.2));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        newCollectionName = (EditText)findViewById(R.id.newCollectionNameEditText);

    }

    public void createClick(View view) {
        String name = newCollectionName.getText().toString();
        Intent intent = new Intent(this, navigationDrawerFragment.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
