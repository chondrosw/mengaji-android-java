package com.example.mengaji_java.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mengaji_java.Model.UserLoginModel;
import com.example.mengaji_java.Model.UserModel;
import com.example.mengaji_java.R;
import com.example.mengaji_java.Service.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,usernameEditText,passwordEditText,dateEditText;
    private Button registerButton;
    private ImageView swipeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameEditText = findViewById(R.id.et_name_register);
        usernameEditText = findViewById(R.id.et_username_register);
        passwordEditText = findViewById(R.id.et_password_register);
        dateEditText = findViewById(R.id.et_date_register);
        registerButton = findViewById(R.id.btn_register);
        swipeLeft = findViewById(R.id.swipeLeft);

        registerButton.setOnClickListener(this);
        swipeLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_register){
            if(nameEditText.getText().toString().isEmpty() || usernameEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty() || dateEditText.getText().toString().isEmpty()){
                Toast.makeText(RegisterActivity.this,"Please enter both the values", Toast.LENGTH_SHORT).show();
                return;
            }
            register(nameEditText.getText().toString(),passwordEditText.getText().toString(),dateEditText.getText().toString(),usernameEditText.getText().toString());


        }else if(view.getId() == R.id.swipeLeft){
            Intent moveLogin = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(moveLogin);
        }
    }

    private void register(String name,String password,String date,String username){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/api/").
                addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        UserModel model = new UserModel(name,username,password,date);
        Call<UserModel> call = retrofitAPI.postRegister(model);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Toast.makeText(RegisterActivity.this,"Register Success",Toast.LENGTH_LONG).show();
                Intent moveHome = new Intent(RegisterActivity.this,TabBarMainActivity.class);
                startActivity(moveHome);
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,"Login Error",Toast.LENGTH_LONG).show();
                System.out.println(t);
            }
        });
    }
}