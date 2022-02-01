package com.example.mengaji_java.View.Activity;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mengaji_java.R;
import com.example.mengaji_java.View.Fragment.DashboardFragment;
import com.example.mengaji_java.View.Fragment.HistoryFragment;
import com.example.mengaji_java.View.Fragment.PersonFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TabBarMainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        DashboardFragment dashboardFragment = new DashboardFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentBTV,dashboardFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DashboardFragment dashboardFragment = new DashboardFragment();
        HistoryFragment historyFragment = new HistoryFragment();
        PersonFragment personFragment = new PersonFragment();
        if(item.getItemId() == R.id.dashboard){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentBTV,dashboardFragment).commit();
        }else if(item.getItemId() == R.id.history){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentBTV,historyFragment).commit();
        }else if(item.getItemId() == R.id.profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentBTV,personFragment).commit();
        }
        return true;
    }
}