package com.example.uee_ndb_neos_bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uee_ndb_neos_bankingapp.ui.home.HomeFragment;
import com.example.uee_ndb_neos_bankingapp.ui.home.HomeViewModel;

public class RK_registered_user_daily_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rk_registered_user_daily_login);
    }


    public void sendToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        Button image = (Button) findViewById(R.id.login_btn);

        EditText editText1 = (EditText) findViewById(R.id.login_password_input);
        String message1 = editText1.getText().toString();
        //Trim whitespace
        message1 = message1.trim();

        //Checks if the message has anything.
        if (message1.length() == 0) {
            editText1.setError("Can't be the Password empty!");
        }
        else{
            startActivity(intent);
        }
    }

    public void clickadminbtn(View view) {

        TextView image1 = (TextView) findViewById(R.id.admin_panal_link);
        image1.setVisibility(View.INVISIBLE);

        TextView image2 = (TextView) findViewById(R.id.not_panal_link);
        image2.setVisibility(View.VISIBLE);
    }


    public void clickNotadminbtn(View view) {

        TextView image1 = (TextView) findViewById(R.id.admin_panal_link);
        image1.setVisibility(View.VISIBLE);

        TextView image2 = (TextView) findViewById(R.id.not_panal_link);
        image2.setVisibility(View.INVISIBLE);
    }


}