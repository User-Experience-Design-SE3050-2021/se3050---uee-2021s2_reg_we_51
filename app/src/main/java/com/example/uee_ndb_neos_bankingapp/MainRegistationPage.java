package com.example.uee_ndb_neos_bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class MainRegistationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registation_page);
    }


    public void changefragment(View view){
        Fragment fragment;
        if(view == findViewById(R.id.URGcheck_boxrk_1)){
            CheckBox checkBox = (CheckBox) findViewById(R.id.URGcheck_boxrk_2);
            checkBox.setChecked(false);

            fragment = new Registation_Fragment_one();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentDefault,fragment);
            ft.commit();
        }
    }


    public void changefragment2(View view){
        Fragment fragment;
        if(view == findViewById(R.id.URGcheck_boxrk_2)){
            CheckBox checkBox = (CheckBox) findViewById(R.id.URGcheck_boxrk_1);
            checkBox.setChecked(false);

            fragment = new RegistationFragmentTwo();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentDefault,fragment);
            ft.commit();
        }
    }

    public void sendToInitialLanding(View view) {
        Intent intent = new Intent(this,  RKInitialLandingOne.class);
        ImageButton image = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }




}