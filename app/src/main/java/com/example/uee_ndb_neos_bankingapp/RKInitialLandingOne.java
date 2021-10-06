package com.example.uee_ndb_neos_bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uee_ndb_neos_bankingapp.ui.fund.FundPayeeForm;

public class RKInitialLandingOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rkinitial_landing_one);
    }

    public void sendToRegistation(View view) {
        Intent intent = new Intent(this,  MainRegistationPage.class);
        Button image = (Button) findViewById(R.id.welcome_main_join_now_btn);
        startActivity(intent);
    }

    public void sendToInitialLogin(View view) {
        Intent intent = new Intent(this,  NewUserFirstLogIN.class);
        Button image = (Button) findViewById(R.id.welcome_main_login_btn);
        startActivity(intent);
    }

}