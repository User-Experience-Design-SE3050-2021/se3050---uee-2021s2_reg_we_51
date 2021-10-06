package com.example.uee_ndb_neos_bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    public void sendToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        ImageButton image = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }
}