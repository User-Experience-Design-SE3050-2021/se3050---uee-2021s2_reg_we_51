package com.example.uee_ndb_neos_bankingapp.ui.fund;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_ndb_neos_bankingapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FundPayeeForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declaring EditText type objects
    EditText account_number, nick_name;
    Spinner spinner, spinner2;
    Button submit;
    DatabaseReference dbRef;
    AlertDialog.Builder builder;
    String bank;
    String accountType;
    Payee payee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_payee_form);

        submit = (Button) findViewById(R.id.button);
        account_number = (EditText) findViewById(R.id.account_number);
        nick_name = (EditText) findViewById(R.id.nick_name);

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bank_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.account_type_list, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        //builder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        payee = new Payee();
        builder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to save this payee ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbRef = FirebaseDatabase.getInstance().getReference().child("Payee");
                                Intent intent = new Intent(FundPayeeForm.this, FundPayeeList.class);
                                startActivity(intent);
                                try {
                                    if (TextUtils.isEmpty(account_number.getText().toString()))
                                        Toast.makeText(getApplicationContext(), "Please enter valid account number", Toast.LENGTH_SHORT).show();
                                    else if (TextUtils.isEmpty(nick_name.getText().toString()))
                                        Toast.makeText(getApplicationContext(), "Please enter nick name of the payee", Toast.LENGTH_SHORT).show();
                                    else {
                                        payee.setAccount_number(Integer.parseInt(account_number.getText().toString().trim()));
                                        payee.setNick_name(nick_name.getText().toString().trim());
                                        payee.setBank(bank);
                                        payee.setAccountType(accountType);
                                        //create child called payee1 in Payee and set the value of payee object
                                        String ids = dbRef.push().getKey();
                                        dbRef.child(ids).setValue(payee);
                                        Toast.makeText(getApplicationContext(),"Payee saved.",Toast.LENGTH_SHORT).show();
                                    }

                                } catch (NumberFormatException e) {
                                    Toast.makeText(getApplicationContext(), "Invalid input for account number.", Toast.LENGTH_SHORT).show();
                                }
                                //startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Canceled",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Alert");
                alert.show();


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        bank = spinner.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), bank, Toast.LENGTH_SHORT).show();
        accountType = spinner2.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), accountType, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void backToList(View view) {
        Intent intent = new Intent(this,  FundPayeeList.class);
        ImageButton image = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }

}
