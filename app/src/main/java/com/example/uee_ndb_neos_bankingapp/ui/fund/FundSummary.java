package com.example.uee_ndb_neos_bankingapp.ui.fund;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_ndb_neos_bankingapp.MainActivity;
import com.example.uee_ndb_neos_bankingapp.R;

public class FundSummary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_summary);
    }
    public void sendToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        ImageButton button = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }
    public void download(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        Button button = (Button) findViewById(R.id.download);
        startActivity(intent);
    }
    public void cancel(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        Button button = (Button) findViewById(R.id.cancel);
        startActivity(intent);
    }
}
