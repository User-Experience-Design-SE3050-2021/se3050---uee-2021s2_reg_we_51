package com.example.uee_ndb_neos_bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FundTransactionOneTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_transaction_onetime);
        Intent intent = getIntent();
    }
    public void sendToFundTransfer(View view) {
        Intent intent = new Intent(this,  FundTransactionForm.class);
        Button button = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }
}
