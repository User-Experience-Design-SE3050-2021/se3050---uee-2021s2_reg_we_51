package com.example.uee_ndb_neos_bankingapp.ui.fund;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_ndb_neos_bankingapp.MainActivity;
import com.example.uee_ndb_neos_bankingapp.R;

public class FundMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_main);

    }
    public void backToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        ImageButton image = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }

    public void sendToFundTransactionForm(View view) {
        Intent intent = new Intent(this,  FundTransactionForm.class);
        RelativeLayout image = (RelativeLayout) findViewById(R.id.fund_transaction);
        startActivity(intent);
    }

    public void sendToPayee(View view) {
        Intent intent = new Intent(this,  FundPayeeList.class);
        RelativeLayout image = (RelativeLayout) findViewById(R.id.fund_payee);
        startActivity(intent);
    }

}
