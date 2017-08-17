package com.clf.chat.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.clf.chat.R;
import com.clf.chat.ui.fragment.*;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    ImageView imgProfile, imgNewMessage;
    RelativeLayout message, archived;
    LinearLayout contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    private void initComponent() {

        message = (RelativeLayout) findViewById(R.id.message);
        message.setOnClickListener(this);

        archived = (RelativeLayout) findViewById(R.id.archived);
        archived.setOnClickListener(this);

        contacts = (LinearLayout) findViewById(R.id.contacts);
        contacts.setOnClickListener(this);

        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        imgProfile.setOnClickListener(this);

        imgNewMessage = (ImageView) findViewById(R.id.imgNewMessage);
        imgNewMessage.setOnClickListener(this);

        displayView(0);
    }

    private void displayView(int index) {
        Fragment fragment = null;

        switch (index) {
            case 0:
                fragment = new MessageFragment();
                break;
            case 1:
                fragment = new AllContactsFragment();
                break;
            case 2:
                fragment = new ArchivedFragment();
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
                message.setBackgroundResource(R.drawable.tab_selected);
                contacts.setBackgroundResource(R.drawable.tab_unselected);
                archived.setBackgroundResource(R.drawable.tab_unselected);
                break;
            case 1:
                message.setBackgroundResource(R.drawable.tab_unselected);
                contacts.setBackgroundResource(R.drawable.tab_selected);
                archived.setBackgroundResource(R.drawable.tab_unselected);
                break;
            case 2:
                message.setBackgroundResource(R.drawable.tab_unselected);
                contacts.setBackgroundResource(R.drawable.tab_unselected);
                archived.setBackgroundResource(R.drawable.tab_selected);
                break;
        }
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.message:
                displayView(0);
                break;
            case R.id.contacts:
                displayView(1);
                break;
            case R.id.archived:
                displayView(2);
                break;
            case R.id.imgProfile:
                intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.imgNewMessage:
                intent = new Intent(MainActivity.this, NewMessageActivity.class);
                startActivity(intent);
                break;
        }
    }
}
