package com.example.drawerlayout_test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

    //툴바 관련
    private Context context;
    private AppBarLayout appBarLayout;
    private NestedScrollView scrollView;
    boolean isExpand = false;

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private EndDrawerToggle mDrawerToggle;
    private boolean EndDrawerToggle_open = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        context = getApplicationContext();
        drawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //액션바를 커스터마이징 하기 위해
        actionBar.setElevation(0); //z축 깊이 0으로 설정 하여 그림자 없애기.



        mDrawerToggle = new EndDrawerToggle(this,drawer,toolbar,R.string.open_drawer,R.string.close_drawer){
            @Override //드로어가 열렸을때
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                EndDrawerToggle_open = true;
            }
            @Override //드로어가 닫혔을때
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                EndDrawerToggle_open = false;
            }
        };

        drawer.addDrawerListener(mDrawerToggle);

    }
}