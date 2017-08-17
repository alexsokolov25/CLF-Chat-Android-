package com.clf.chat.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.clf.chat.R;

public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtReceiver, txtSubject, txtMessage;
    TextView txtSend;
    ImageView imgBack, imgAdd, imgAttach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        initComponent();
    }

    private void initComponent() {
        txtReceiver = (EditText) findViewById(R.id.txtReceiver);
        txtReceiver.setBackgroundResource(android.R.color.transparent);

        txtSubject = (EditText) findViewById(R.id.txtSubject);
        txtSubject.setBackgroundResource(android.R.color.transparent);

        txtMessage = (EditText) findViewById(R.id.txtMessage);
        txtMessage.setBackgroundResource(android.R.color.transparent);

        txtSend = (TextView) findViewById(R.id.txtSend);
        txtSend.setOnClickListener(this);

        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);

        imgAdd = (ImageView) findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(this);

        imgAttach = (ImageView) findViewById(R.id.imgAttach);
        imgAttach.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtSend:
                break;
            case R.id.imgAdd:
                Intent intent = new Intent(NewMessageActivity.this, AddUserActivity.class);
                startActivity(intent);
                break;
            case R.id.imgAttach:
                break;
            case R.id.imgBack:
                finish();
                break;
        }
    }
}
