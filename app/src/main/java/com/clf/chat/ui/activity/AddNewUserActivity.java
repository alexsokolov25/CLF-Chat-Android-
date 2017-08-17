package com.clf.chat.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.clf.chat.R;

public class AddNewUserActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtEmail, txtPassword, txtFirst, txtLast, txtPhone, txtConfirmPw;
    TextView txtCreate;
    ImageView imgBack, imgOn, imgOff;
    LinearLayout manger_layout, user_layout;

    boolean bManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        initComponent();
    }

    private void initComponent() {

        bManger = false;

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtEmail.setBackgroundResource(android.R.color.transparent);

        txtFirst = (EditText) findViewById(R.id.txtFirst);
        txtFirst.setBackgroundResource(android.R.color.transparent);

        txtLast = (EditText) findViewById(R.id.txtLast);
        txtLast.setBackgroundResource(android.R.color.transparent);

        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtPhone.setBackgroundResource(android.R.color.transparent);

        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPassword.setBackgroundResource(android.R.color.transparent);

        txtConfirmPw = (EditText) findViewById(R.id.txtConfirmPw);
        txtConfirmPw.setBackgroundResource(android.R.color.transparent);

        imgOn = (ImageView) findViewById(R.id.img_on);
        imgOff = (ImageView) findViewById(R.id.img_off);

        manger_layout = (LinearLayout) findViewById(R.id.manager_layout);
        manger_layout.setOnClickListener(this);

        user_layout = (LinearLayout) findViewById(R.id.user_layout);
        user_layout.setOnClickListener(this);

        txtCreate = (TextView) findViewById(R.id.txtCreate);
        txtCreate.setOnClickListener(this);

        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);

        selPermission();
    }

    private void selPermission() {

        bManger = !bManger;
        if (bManger) {
            imgOn.setBackgroundResource(R.drawable.radio_on);
            imgOff.setBackgroundResource(R.drawable.radio_off);
        } else {
            imgOn.setBackgroundResource(R.drawable.radio_off);
            imgOff.setBackgroundResource(R.drawable.radio_on);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtCreate:
                break;
            case R.id.imgBack:
                finish();
                break;
            case R.id.manager_layout:
                selPermission();
                break;
            case R.id.user_layout:
                selPermission();
                break;
        }
    }
}


