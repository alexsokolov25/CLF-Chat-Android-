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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.clf.chat.R;
import com.clf.chat.ui.activity.ChatActivity;
import com.clf.chat.ui.model.*;

import java.util.ArrayList;

public class ArchivedFragment extends Fragment {

    private ListView listView;
    ArrayList archived_data = new ArrayList<ArchiveItemModel>();
    private ArchivedAdapter adapter;

    Activity mParent;

    String data[][] = {{"Sarah", "Sending Guests Smith. Please comp dessert", "Will Do", "8/15/17 12:15 PM"}, {"John", "2 top @ 6 pm", "You're welcome", "8/14/17 1:05 PM"}};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mParent = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_my_group, container, false);

        initComponent(rootView);

        return rootView;
    }

    private void initComponent(View rootView) {
        for(int i = 0 ; i < 2 ; i++) {
            ArchiveItemModel item = new ArchiveItemModel();
            archived_data.add(item);
        }

        listView = (ListView) rootView.findViewById(R.id.listView);
        adapter = new ArchivedAdapter(archived_data, mParent);
        listView.setAdapter(adapter);

    }

    class ArchivedAdapter extends ArrayAdapter<ArchiveItemModel> {

        private ArrayList<ArchiveItemModel> itemList;
        private Context context;

        public ArchivedAdapter(ArrayList<ArchiveItemModel> itemList, Context ctx) {
            super(ctx, android.R.layout.simple_list_item_1, itemList);
            this.itemList = itemList;
            this.context = ctx;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View v = convertView;

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.message_history_listview_item, null);

            TextView txtGroupId = (TextView) v.findViewById(R.id.txtGroupId);
            txtGroupId.setText(data[position][0]);

            TextView txtSubject = (TextView) v.findViewById(R.id.txtSubject);
            txtSubject.setText(data[position][1]);

            TextView txtMessage = (TextView) v.findViewById(R.id.txtMessage);
            txtMessage.setText(data[position][2]);

            TextView txtTime = (TextView) v.findViewById(R.id.txtTime);
            txtTime.setText(data[position][3]);

            return v;
        }
    }
}
