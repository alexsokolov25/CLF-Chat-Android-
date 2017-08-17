package com.clf.chat.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.clf.chat.R;
import com.clf.chat.ui.fragment.*;

public class AddUserActivity extends FragmentActivity implements View.OnClickListener {

    ImageView imgBack, imgAdd;
    LinearLayout myGroup, contacts;
    public static TextView txtGroupId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        initComponent();
    }

    private void initComponent() {

        txtGroupId = (TextView) findViewById(R.id.txtGroupId);

        myGroup = (LinearLayout) findViewById(R.id.myGroup);
        myGroup.setOnClickListener(this);

        contacts = (LinearLayout) findViewById(R.id.contacts);
        contacts.setOnClickListener(this);

        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);

        imgAdd = (ImageView) findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(this);

        displayView(0);
    }

    private void displayView(int index) {
        Fragment fragment = null;

        switch (index) {
            case 0:
                fragment = new MyGroupFragment();
                break;
            case 1:
                fragment = new ContactsFragment();
                break;
            default:
                break;
        }

        setTabSelect(index);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_place, fragment).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    private void setTabSelect(int index) {

        switch(index) {
            case 0:
                myGroup.setBackgroundResource(R.drawable.tab_selected);
                contacts.setBackgroundResource(R.drawable.tab_unselected);
                break;
            case 1:
                myGroup.setBackgroundResource(R.drawable.tab_unselected);
                contacts.setBackgroundResource(R.drawable.tab_selected);
                break;
        }
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.myGroup:
                displayView(0);
                break;
            case R.id.contacts:
                displayView(1);
                break;
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgAdd:

                break;
        }
    }
}
