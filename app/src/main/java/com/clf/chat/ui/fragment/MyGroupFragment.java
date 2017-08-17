package com.clf.chat.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.clf.chat.R;
import com.clf.chat.ui.activity.AddUserActivity;
import com.clf.chat.ui.model.*;

import java.util.ArrayList;

public class MyGroupFragment extends Fragment {

    TextView txtGroupId;
    private ListView listView;
    ArrayList mygroup_data = new ArrayList<MyGroupItemModel>();
    private MyGroupAdapter adapter;

    Activity mParent;

    String group_user[] = {"Bill Stevens", "Rose Johnson", "Rob Lee"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mParent = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_my_group, container, false);

        initComponent(rootView);

        return rootView;
    }

    private void initComponent(View rootView) {

        txtGroupId = (TextView) rootView.findViewById(R.id.txtGroupId);

        for(int i = 0 ; i < 3 ; i++) {
            MyGroupItemModel item = new MyGroupItemModel();
            mygroup_data.add(item);
        }

        listView = (ListView) rootView.findViewById(R.id.listView);
        adapter = new MyGroupAdapter(mygroup_data, mParent);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(Color.parseColor("#eeeef3"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String temp = ((AddUserActivity) mParent).txtGroupId.getText().toString();
                ((AddUserActivity) mParent).txtGroupId.setText(temp + group_user[position] + ", ");
            }
        });
    }

    class MyGroupAdapter extends ArrayAdapter<MyGroupItemModel> {

        private ArrayList<MyGroupItemModel> itemList;
        private Context context;

        public MyGroupAdapter(ArrayList<MyGroupItemModel> itemList, Context ctx) {
            super(ctx, android.R.layout.simple_list_item_1, itemList);
            this.itemList = itemList;
            this.context = ctx;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View v = convertView;

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.add_user_listview_item, null);

            TextView txtName = (TextView) v.findViewById(R.id.txtName);
            txtName.setText(group_user[position]);

            TextView txtCompany = (TextView) v.findViewById(R.id.txtCompany);
            txtCompany.setText("Cosmo");

            return v;
        }
    }
}
