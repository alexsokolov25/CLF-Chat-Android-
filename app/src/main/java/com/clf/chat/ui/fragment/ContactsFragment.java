package com.clf.chat.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.clf.chat.R;
import com.clf.chat.ui.activity.AddNewUserActivity;
import com.clf.chat.ui.activity.AddUserActivity;
import com.clf.chat.ui.adapter.*;
import com.clf.chat.ui.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ContactsFragment extends Fragment {

    Activity mParent;

    ExpandableListView contactsList;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mParent = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        initComponent(rootView);

        return rootView;
    }

    private void initComponent(View rootView) {

        contactsList = (ExpandableListView) rootView.findViewById(R.id.listView);
        expandableListDetail = ExpandableListDataPump.getData(1);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new AddUserContactsExpandableListAdapter(mParent, expandableListTitle, expandableListDetail);
        contactsList.setAdapter(expandableListAdapter);
        contactsList.expandGroup(0);

        contactsList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String user = expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition);

                String temp = ((AddUserActivity) mParent).txtGroupId.getText().toString();
                ((AddUserActivity) mParent).txtGroupId.setText(temp + user + ", ");

                return false;
            }
        });

    }
}

