package com.wallpaper.wallpapers;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @BindView(R.id.et_username) EditText mUser;
    @BindView(R.id.et_password) EditText mPassword;
    @BindView(R.id.et_email) EditText mEmail;
    @BindView(R.id.et_names) EditText mNames;
    @BindView(R.id.btn_register) Button btnRegister;

    private String TAG = RegisterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        eventUI();
    }

    public void init(){

        ButterKnife.bind(this);

        mToolbar.setTitle("Registrate");
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnRegister.setOnClickListener(this);
    }

    public boolean verify(){

        if (mUser.getText().toString().toString().equals("")){
            return false;
        }

        if (mPassword.getText().toString().toString().equals("")){
            return false;
        }

        if (mEmail.getText().toString().toString().equals("")){
            return false;
        }

        if (mNames.getText().toString().toString().equals("")){
            return false;
        }

        return true;

    }

    public void nextActivity(){
        Log.d(TAG, " ----------------> nextActivity");
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void eventUI(){
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                service();
                break;
        }
    }

    public void service(){
        if(verify()){
            Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
