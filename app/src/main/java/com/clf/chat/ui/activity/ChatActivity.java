package com.clf.chat.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import com.clf.chat.R;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgBack, imgTrash, imgAddGroup, imgAttach;
    TextView txtSend;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initComponent();
    }

    private void initComponent() {
        txtMessage = (EditText) findViewById(R.id.txtMessage);
        txtMessage.setBackgroundResource(android.R.color.transparent);

        txtSend = (TextView) findViewById(R.id.txtSend);
        txtSend.setOnClickListener(this);

        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);

        imgTrash = (ImageView) findViewById(R.id.imgTrash);
        imgTrash.setOnClickListener(this);

        imgAddGroup = (ImageView) findViewById(R.id.imgAddGroup);
        imgAddGroup.setOnClickListener(this);

        imgAttach = (ImageView) findViewById(R.id.imgAttach);
        imgAttach.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgTrash:

                break;
            case R.id.imgAddGroup:

                break;
            case R.id.imgAttach:

                break;
        }
    }
}
