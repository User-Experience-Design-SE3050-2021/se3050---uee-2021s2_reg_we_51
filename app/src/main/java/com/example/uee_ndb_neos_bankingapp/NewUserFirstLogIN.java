package com.example.uee_ndb_neos_bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewUserFirstLogIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_first_log_in);
    }

    public void sendToUsualLogin(View view) {
        Intent intent = new Intent(this,  RK_registered_user_daily_login.class);
        Button image = (Button) findViewById(R.id.login_btn);

        EditText editText1 = (EditText) findViewById(R.id.UHN_login_Usn_input);
        String message1 = editText1.getText().toString();
        //Trim whitespace
        message1 = message1.trim();


        EditText editText2 = (EditText) findViewById(R.id.UHNlogin_password_input);
        String message2 = editText2.getText().toString();
        //Trim whitespace
        message2 = message2.trim();


        //Checks if the message has anything.
        if (message1.length() == 0) {
            editText1.setError("Can't be the user name empty!");
        }
        else if (message2.length() == 0) {
            editText2.setError("Can't be the password empty!");
        }
        else{
            startActivity(intent);
        }

    }


    public void clickadminbtn(View view) {

        TextView image1 = (TextView) findViewById(R.id.UHNadmin_panal_link);
        image1.setVisibility(View.INVISIBLE);

        TextView image2 = (TextView) findViewById(R.id.UHNnot_panal_link);
        image2.setVisibility(View.VISIBLE);
    }


    public void clickNotadminbtn(View view) {

        TextView image1 = (TextView) findViewById(R.id.UHNadmin_panal_link);
        image1.setVisibility(View.VISIBLE);

        TextView image2 = (TextView) findViewById(R.id.UHNnot_panal_link);
        image2.setVisibility(View.INVISIBLE);
    }



}