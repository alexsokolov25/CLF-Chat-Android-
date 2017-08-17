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
import android.widget.*;

import com.clf.chat.R;
import com.clf.chat.ui.activity.ChatActivity;
import com.clf.chat.ui.model.MessageItemModel;

import java.util.ArrayList;

public class MessageFragment extends Fragment {

    private ListView listView;
    ArrayList message_data = new ArrayList<MessageItemModel>();
    private MessageHistoryAdapter adapter;

    Activity mParent;

    String data[][] = {{"Sarah, Alec, John, +1", "Need Reservation for Party of 4 @ 8 pm", "Yes, I will send over a pic of a dish that the Chef just...", "4:15 PM"}, {"Frank", "Party of 12?", "Are you able to do a party for 12 people tomorrow ev?", "10:51 AM"}};

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
            MessageItemModel item = new MessageItemModel();
            message_data.add(item);
        }

        listView = (ListView) rootView.findViewById(R.id.listView);
        adapter = new MessageHistoryAdapter(message_data, mParent);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(Color.parseColor("#eeeef3"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mParent, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    class MessageHistoryAdapter extends ArrayAdapter<MessageItemModel> {

        private ArrayList<MessageItemModel> itemList;
        private Context context;

        public MessageHistoryAdapter(ArrayList<MessageItemModel> itemList, Context ctx) {
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
