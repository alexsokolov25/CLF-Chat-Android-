package com.clf.chat.ui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData(int index) {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        if (index == 0) {
            List<String> scarpetta = new ArrayList<String>();
            scarpetta.add("William Adama");
            scarpetta.add("Barray Allen");
            scarpetta.add("Wedge Antilles");
            scarpetta.add("Padme Amidala");
            scarpetta.add("Alyssa Ashcroft");

            List<String> mastro = new ArrayList<String>();
            mastro.add("Petyr Baelish");

            List<String> del_frisco = new ArrayList<String>();
            del_frisco.add("Robert Baratheon");

            expandableListDetail.put("Scarpetta", scarpetta);
            expandableListDetail.put("Mastro", mastro);
            expandableListDetail.put("Del Frisco", del_frisco);
        } else {
            List<String> scarpetta = new ArrayList<String>();
            scarpetta.add("Janice Stu");
            scarpetta.add("Brad Coop");
            scarpetta.add("Joe Simmons");

            expandableListDetail.put("Scarpetta", scarpetta);
        }

        return expandableListDetail;
    }
}
