package com.clf.chat.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.clf.chat.R;

public class SignupActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword, txtFirst, txtLast, txtPhone, txtCompany, txtConfirmPw;
    TextView txtRegister;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initComponent();
    }

    private void initComponent() {
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtEmail.setBackgroundResource(android.R.color.transparent);

        txtFirst = (EditText) findViewById(R.id.txtFirst);
        txtFirst.setBackgroundResource(android.R.color.transparent);

        txtLast = (EditText) findViewById(R.id.txtLast);
        txtLast.setBackgroundResource(android.R.color.transparent);

        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtPhone.setBackgroundResource(android.R.color.transparent);

        txtCompany = (EditText) findViewById(R.id.txtCompanyName);
        txtCompany.setBackgroundResource(android.R.color.transparent);

        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPassword.setBackgroundResource(android.R.color.transparent);

        txtConfirmPw = (EditText) findViewById(R.id.txtConfirmPw);
        txtConfirmPw.setBackgroundResource(android.R.color.transparent);

        txtRegister = (TextView) findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}

