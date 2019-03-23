package com.sarjh.tender;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Feed extends Fragment {

    CardView card1,card2;
    Button apply1,apply2;

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.feed, container, false);

        
        // Inflate the layout for this fragment

        return v;
    }



}
