package com.example.mengaji_java.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mengaji_java.MainActivity;
import com.example.mengaji_java.Model.UserLoginModel;
import com.example.mengaji_java.Model.UserModel;
import com.example.mengaji_java.R;
import com.example.mengaji_java.Service.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userNameEditText,passwordEditText;
    private Button postButton;
    private ImageView arrowButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        postButton = findViewById(R.id.btn_login);
        arrowButton = findViewById(R.id.swipeRight);
        arrowButton.setOnClickListener(this);
        postButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_login){
            if(userNameEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this,"Please enter both the values", Toast.LENGTH_SHORT).show();
                return;
            }
            login(userNameEditText.getText().toString(),passwordEditText.getText().toString());

        }else if(view.getId() == R.id.swipeRight){
            Intent goToRegister = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(goToRegister);
        }
    }

    private  void login(String username,String password){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/api/").
                addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        UserLoginModel model = new UserLoginModel(username,password);
        Call<UserLoginModel> call = retrofitAPI.postLogin(model);

        call.enqueue(new Callback<UserLoginModel>() {
            @Override
            public void onResponse(Call<UserLoginModel> call, Response<UserLoginModel> response) {
                Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                Intent moveHome = new Intent(LoginActivity.this,TabBarMainActivity.class);
                startActivity(moveHome);
            }

            @Override
            public void onFailure(Call<UserLoginModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_LONG).show();
                System.out.println(t);
            }
        });
    }
}