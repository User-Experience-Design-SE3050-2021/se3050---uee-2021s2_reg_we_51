package com.example.uee_ndb_neos_bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FundTransactionForm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_transaction_form);
    }

    public void sendToOneTimeFundTRanfer(View view) {
        Intent intent = new Intent(this,  FundTransactionOneTime.class);
        Button button = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }
}
