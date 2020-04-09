package com.example.bottomnavtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        final BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);
//        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                navigationDrawerFragment bottomNavFragment = new navigationDrawerFragment();
//                bottomNavFragment.show(getSupportFragmentManager(),"TAG");
//            }
//        });

        final FloatingActionButton fab = findViewById(R.id.floatingActionButton);

    }

    public void onFabClick(View v) {
        navigationDrawerFragment bottomNavFragment = new navigationDrawerFragment();
        bottomNavFragment.show(getSupportFragmentManager(),"TAG");
    }


}
