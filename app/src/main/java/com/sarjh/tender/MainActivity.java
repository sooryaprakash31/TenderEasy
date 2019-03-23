package com.sarjh.tender;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {

    FrameLayout fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeFragment (View view)
    {
        fl = findViewById(R.id.frag);
        Fragment fragment;
            {
                if(view == findViewById(R.id.button)){
                    fragment = new SignUp();
                    fl.removeAllViews();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.frag,fragment);
                    ft.commit();
                }
                if(view== findViewById(R.id.button2)){
                    fragment = new Login();
                    fl.removeAllViews();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.frag,fragment);
                    ft.commit();
                }
            }

        }
    }

