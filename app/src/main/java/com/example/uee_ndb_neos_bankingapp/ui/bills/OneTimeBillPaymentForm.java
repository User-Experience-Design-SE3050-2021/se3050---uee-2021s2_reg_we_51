package com.example.uee_ndb_neos_bankingapp.ui.bills;

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

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.uee_ndb_neos_bankingapp.MainActivity;
        import com.example.uee_ndb_neos_bankingapp.R;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class OneTimeBillPaymentForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText ref_num, amount, remark;
    Spinner spinner1, spinner2;
    Button button;
    DatabaseReference dbRef;
    String category, provider;
    BillPaymentOneTime billPaymentOneTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onetime_billpayment);

        button = (Button) findViewById(R.id.button);
        ref_num = (EditText) findViewById(R.id.ref_num);
        amount = (EditText) findViewById(R.id.amount);
        remark = (EditText) findViewById(R.id.remark);

        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.biller_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Service_provider, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        billPaymentOneTime = new BillPaymentOneTime();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Bill-payment-onetime");
                Intent intent = new Intent(OneTimeBillPaymentForm.this, MainActivity.class);
                startActivity(intent);
                try {
                    if (TextUtils.isEmpty(amount.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a amount", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(remark.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter the remark", Toast.LENGTH_SHORT).show();
                    else {
                        billPaymentOneTime.setAmount(Float.parseFloat(amount.getText().toString().trim()));
                        billPaymentOneTime.setRefNum(Integer.parseInt(ref_num.getText().toString().trim()));
                        billPaymentOneTime.setRemark(remark.getText().toString().trim());
                        billPaymentOneTime.setCategory(category);
                        billPaymentOneTime.setProvider(provider);
                        //create child called payee1 in Payee and set the value of payee object
                        String ids = dbRef.push().getKey();
                        dbRef.child(ids).setValue(billPaymentOneTime);
                        Toast.makeText(getApplicationContext(), "Bill payment succeeded.", Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid input for amount.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void sendToFundTransfer(View view) {
        Intent intent = new Intent(this,  AddBiller.class);
        Button button = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }

    public void sendToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        ImageButton button = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }

    public void submit(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        Button button = (Button) findViewById(R.id.button);
        startActivity(intent);
    }
    public void cancel(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        Button button = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        provider = spinner2.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), provider, Toast.LENGTH_SHORT).show();
        category = spinner1.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), category, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

