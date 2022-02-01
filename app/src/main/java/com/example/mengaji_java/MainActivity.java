package com.example.mengaji_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mengaji_java.View.Activity.LoginActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMoveLogin = findViewById(R.id.goLogin);
        btnMoveLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.goLogin){
            Intent moveIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(moveIntent);
        }
    }
}