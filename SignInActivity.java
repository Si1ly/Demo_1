package com.example.nmta.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nmta.R;
import com.example.nmta.data.Account.FirebaseAccount;

public class SignInActivity extends AppCompatActivity {
    EditText edt_user_signin,edt_pass_signin;
    Button create_account_signin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);

        FirebaseAccount firebaseAccount = new FirebaseAccount();

        edt_pass_signin = (EditText) findViewById(R.id.edt_pass_signin);
        edt_user_signin = (EditText) findViewById(R.id.edt_user_signin);

        create_account_signin = (Button) findViewById(R.id.bt_create_signin);
        create_account_signin.setOnClickListener(view -> {
            String user = edt_user_signin.getText().toString();
            String pass = edt_pass_signin.getText().toString();
            firebaseAccount.CreateAccountwithEmailandPassword(user,pass,SignInActivity.this);
        });
    }
}
