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
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_ndb_neos_bankingapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FundTransactionOneTimeForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText account_number, amount, remark;
    Spinner spinner;
    Button fundButton;
    String bank;
    AlertDialog.Builder builder;
    DatabaseReference dbRef;
    FundTransactionOneTime fundTransactionOneTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_transaction_onetime);
        Intent intent = getIntent();

        fundButton = (Button) findViewById(R.id.button);
        amount = (EditText) findViewById(R.id.amount);
        remark = (EditText) findViewById(R.id.remark);
        account_number = (EditText) findViewById(R.id.account_number);
        builder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        fundTransactionOneTime = new FundTransactionOneTime();

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bank_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        fundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to do this transaction ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbRef = FirebaseDatabase.getInstance().getReference().child("Fund-onetime");
                                Intent intent = new Intent(getApplicationContext(),  FundSummary.class);
                                startActivity(intent);
                                try {
                                    if (TextUtils.isEmpty(amount.getText().toString()))
                                        Toast.makeText(getApplicationContext(), "Please enter amount", Toast.LENGTH_SHORT).show();
                                    else {
                                        fundTransactionOneTime.setPayeeAccountNumber(Integer.parseInt(account_number.getText().toString().trim()));
                                        fundTransactionOneTime.setAmount(Float.parseFloat(amount.getText().toString().trim()));
                                        fundTransactionOneTime.setRemark(remark.getText().toString().trim());
                                        fundTransactionOneTime.setPayeeAccountBank(bank);
                                        //create child called payee1 in Payee and set the value of payee object
                                        String ids = dbRef.push().getKey();
                                        dbRef.child(ids).setValue(fundTransactionOneTime);
                                        Toast.makeText(getApplicationContext(),"Fund successfully transferred.",Toast.LENGTH_SHORT).show();
                                    }

                                } catch (NumberFormatException e) {
                                    Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                }
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
                //Creating dialog box
                //done
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Alert");
                alert.show();
            }
        });
    }
    public void sendToFundTransfer(View view) {
        Intent intent = new Intent(this,  FundTransactionForm.class);
        Button button = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        bank = spinner.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), bank, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
