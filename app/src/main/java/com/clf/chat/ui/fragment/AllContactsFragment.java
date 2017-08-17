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
import com.clf.chat.ui.adapter.AllContactsExpandableListAdapter;
import com.clf.chat.ui.model.AllContactItemModel;
import com.clf.chat.ui.model.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AllContactsFragment extends Fragment implements View.OnClickListener {

    Activity mParent;

    ImageView imgTab, imgAdd, imgSwitch;
    TextView lblSort;

    LinearLayout myGroupLayout, allContactsLayout;

    boolean bMyGroup, bCompany;

    ListView myGroupList;
    ArrayList group_data = new ArrayList<AllContactItemModel>();
    private MyGroupAdapter adapter;

    String group_user[] = {"Bill Stevens", "Rose Johnson", "Rob Lee"};

    ExpandableListView contactsList;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mParent = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_contacts_1, container, false);

        initComponent(rootView);

        return rootView;
    }

    private void initComponent(View rootView) {

        bMyGroup = true;
        bCompany = true;

        myGroupLayout = (LinearLayout) rootView.findViewById(R.id.myGroupLayout);
        allContactsLayout = (LinearLayout) rootView.findViewById(R.id.allContactsLayout);
        allContactsLayout.setVisibility(View.GONE);

        lblSort = (TextView) rootView.findViewById(R.id.lblSort);

        imgTab = (ImageView) rootView.findViewById(R.id.imgTab);
        imgTab.setOnClickListener(this);
        imgTab.setBackgroundResource(R.drawable.group);

        imgAdd = (ImageView) rootView.findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(this);

        imgSwitch = (ImageView) rootView.findViewById(R.id.imgSwitch);
        imgSwitch.setOnClickListener(this);
        imgSwitch.setBackgroundResource(R.drawable.ic_switch_on);

        for(int i = 0 ; i < 3 ; i++) {
            AllContactItemModel item = new AllContactItemModel();
            group_data.add(item);
        }

        myGroupList = (ListView) rootView.findViewById(R.id.myGroupList);
        adapter = new MyGroupAdapter(group_data, mParent);
        myGroupList.setAdapter(adapter);

        contactsList = (ExpandableListView) rootView.findViewById(R.id.contactsList);
        expandableListDetail = ExpandableListDataPump.getData(0);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new AllContactsExpandableListAdapter(mParent, expandableListTitle, expandableListDetail);
        contactsList.setAdapter(expandableListAdapter);

        for (int i = 0 ; i < expandableListTitle.size() ; i++) {
            contactsList.expandGroup(i);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTab:
                bMyGroup = !bMyGroup;
                if (bMyGroup) {
                    imgTab.setBackgroundResource(R.drawable.group);

                    myGroupLayout.setVisibility(View.VISIBLE);
                    allContactsLayout.setVisibility(View.GONE);
                } else {
                    imgTab.setBackgroundResource(R.drawable.contacts);

                    myGroupLayout.setVisibility(View.GONE);
                    allContactsLayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.imgAdd:
                Intent intent = new Intent(mParent, AddNewUserActivity.class);
                startActivity(intent);
                break;
            case R.id.imgSwitch:
                bCompany = !bCompany;
                if (bCompany) {
                    imgSwitch.setBackgroundResource(R.drawable.ic_switch_on);
                } else {
                    imgSwitch.setBackgroundResource(R.drawable.ic_switch_off);
                }
                break;
        }
    }

    class MyGroupAdapter extends ArrayAdapter<AllContactItemModel> {

        private ArrayList<AllContactItemModel> itemList;
        private Context context;

        public MyGroupAdapter(ArrayList<AllContactItemModel> itemList, Context ctx) {
            super(ctx, android.R.layout.simple_list_item_1, itemList);
            this.itemList = itemList;
            this.context = ctx;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View v = convertView;

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.contact_listview_item, null);

            TextView txtName = (TextView) v.findViewById(R.id.txtName);
            txtName.setText(group_user[position]);

            TextView txtCompany = (TextView) v.findViewById(R.id.txtCompany);
            txtCompany.setVisibility(View.GONE);

            return v;
        }
    }
}

