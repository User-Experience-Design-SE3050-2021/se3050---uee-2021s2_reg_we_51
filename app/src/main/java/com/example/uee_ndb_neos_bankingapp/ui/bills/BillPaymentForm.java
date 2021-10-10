package com.example.uee_ndb_neos_bankingapp.ui.bills;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
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

import com.example.uee_ndb_neos_bankingapp.MainActivity;
import com.example.uee_ndb_neos_bankingapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BillPaymentForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText amount, remark;
    Spinner spinner;
    Button button;
    DatabaseReference dbRef;
    String biller;
    AlertDialog.Builder builder;
    BillPayment billPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_payment);

        button = (Button) findViewById(R.id.button);
        amount = (EditText) findViewById(R.id.amount);
        remark = (EditText) findViewById(R.id.remark);

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.biller_nickname, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        billPayment = new BillPayment();
        builder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to pay this bill?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbRef = FirebaseDatabase.getInstance().getReference().child("Bill-payment");
                                Intent intent = new Intent(BillPaymentForm.this, MainActivity.class);
                                startActivity(intent);
                                try {
                                    if (TextUtils.isEmpty(amount.getText().toString()))
                                        Toast.makeText(getApplicationContext(), "Please enter a amount", Toast.LENGTH_SHORT).show();
                                    else if (TextUtils.isEmpty(remark.getText().toString()))
                                        Toast.makeText(getApplicationContext(), "Please enter the remark", Toast.LENGTH_SHORT).show();
                                    else {
                                        billPayment.setAmount(Float.parseFloat(amount.getText().toString().trim()));
                                        billPayment.setRemark(remark.getText().toString().trim());
                                        billPayment.setBiller(biller);
                                        //create child called payee1 in Payee and set the value of payee object
                                        String ids = dbRef.push().getKey();
                                        dbRef.child(ids).setValue(billPayment);
                                        Toast.makeText(getApplicationContext(), "Bill payment succeeded.", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (NumberFormatException e) {
                                    Toast.makeText(getApplicationContext(), "Invalid input for amount.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "Canceled",
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

    public void sendToOneTimeBillPayment(View view) {
        Intent intent = new Intent(this, OneTimeBillPaymentForm.class);
        Button button = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }

    public void sendToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        ImageButton button = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        biller = spinner.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), biller, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

