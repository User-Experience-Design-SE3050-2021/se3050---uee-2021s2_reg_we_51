package com.example.uee_ndb_neos_bankingapp.ui.fund;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_ndb_neos_bankingapp.MainActivity;
import com.example.uee_ndb_neos_bankingapp.R;

public class FundPayeeList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_payee_list);
    }

    public void sendToFundPayeeForm(View view) {
        Intent intent = new Intent(this,  FundPayeeForm.class);
        ImageButton image = (ImageButton) findViewById(R.id.add);
        startActivity(intent);
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        ImageButton image = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }

    public void sendToPayeeUpdate(View view) {
        Intent intent = new Intent(this,  FundPayeeUpdateDelete.class);
        RelativeLayout item1 = (RelativeLayout) findViewById(R.id.item1);
        startActivity(intent);
    }
}
