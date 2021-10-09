package com.example.uee_ndb_neos_bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.uee_ndb_neos_bankingapp.ui.bills.BilletList;
import com.example.uee_ndb_neos_bankingapp.ui.fund.FundMain;

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

    public void sendToPayeeManagement(View view) {
        Intent intent = new Intent(this,  FundMain.class);
        CardView button = (CardView) findViewById(R.id.cardView20);
        startActivity(intent);
    }

    public void sendToBillManagement(View view) {
        Intent intent = new Intent(this,  BilletList.class);
        CardView button = (CardView) findViewById(R.id.cardView12);
        startActivity(intent);
    }

    public void sendToContactUs(View view) {
        Intent intent = new Intent(this,  ContactUs.class);
        CardView button = (CardView) findViewById(R.id.cardView16);
        startActivity(intent);
    }
}