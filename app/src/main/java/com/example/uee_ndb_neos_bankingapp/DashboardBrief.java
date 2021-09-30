package com.example.uee_ndb_neos_bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.uee_ndb_neos_bankingapp.ui.home.HomeFragment;

public class DashboardBrief extends AppCompatActivity {

    ImageButton ibtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_brief);

        ibtn1 = (ImageButton) findViewById(R.id.imageButton13);

        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}