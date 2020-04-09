package com.example.bottomnavtest;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class navigationDrawerFragment extends BottomSheetDialogFragment {

    public ArrayList<String> extraMenuNames;
    public static final String EXTRA_NAME = "name";
    public NavigationView navigationView;
    public View view;

    public navigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        navigationView = view.findViewById(R.id.navigationView);

        fillArraylist();
        hideItem(view, extraMenuNames, navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            // get object of menuItem selected
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.favoritesMenu:
                        Toast.makeText(getActivity(), "Open Favorites", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.wishlistMenu:
                        Toast.makeText(getActivity(), "Open Wishlist", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.addMenu:
                        Intent intent = new Intent(getActivity(), CustomPopup.class);
                        startActivity(intent);
                        break;
                }

                return false;
            }
        });
        return view;
    }


//    https://stackoverflow.com/questions/31954993/hide-a-navigation-drawer-menu-item-android
    public void hideItem(View view, ArrayList<String> extraMenuNames, NavigationView navigationView) {
        Menu nav_Menu = navigationView.getMenu();
        if (extraMenuNames == null) {
            nav_Menu.findItem(R.id.extra1Menu).setVisible(false);
            nav_Menu.findItem(R.id.extra2Menu).setVisible(false);
        }
    }

    public void fillArraylist () {
        Intent intent = getActivity().getIntent();

        if (intent.getStringExtra(EXTRA_NAME) != null) {
            extraMenuNames.add(intent.getStringExtra(EXTRA_NAME));
        }
    }

}
