package com.wallpaper.wallpapers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.et_username) EditText mUser;
    @BindView(R.id.et_password) EditText mPassrod;
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.btn_register) TextView btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        mUser.setText("cyupanqui");
        mPassrod.setText("admin");

        mPassrod.setSelection(mPassrod.getText().length());
    }

    public String getUser(){
        return mUser.getText().toString();
    }

    public String getPassword(){
        return mPassrod.getText().toString();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_register:
                register();
                break;
        }
    }

    public void login(){
        if (getUser().equals("cyupanqui") && getPassword().equals("admin")){
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, WallpapersActivity.class));
        }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(){
        startActivity(new Intent(this, RegisterActivity.class));
    }

}
