package com.example.uee_ndb_neos_bankingapp.ui.bills;

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
import com.example.uee_ndb_neos_bankingapp.ui.fund.FundPayeeForm;
import com.example.uee_ndb_neos_bankingapp.ui.fund.FundPayeeList;
import com.example.uee_ndb_neos_bankingapp.ui.fund.FundTransaction;
import com.example.uee_ndb_neos_bankingapp.ui.fund.Payee;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBiller extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText nick_name, ref_num;
    Spinner spinner1, spinner2;
    Button button;
    DatabaseReference dbRef;
    String provider, category;
    Biller biller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_biller);

        button = (Button) findViewById(R.id.button2);
        ref_num = (EditText) findViewById(R.id.ref_num);
        nick_name = (EditText) findViewById(R.id.nick_name);

        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Service_provider, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.biller_category, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        biller = new Biller();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Biller");
                Intent intent = new Intent(AddBiller.this, BilletList.class);
                startActivity(intent);
                try {
                    if (TextUtils.isEmpty(ref_num.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a reference number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(nick_name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter nick name of the biller", Toast.LENGTH_SHORT).show();
                    else {
                        biller.setRefNum(Integer.parseInt(ref_num.getText().toString().trim()));
                        biller.setNickname(nick_name.getText().toString().trim());
                        biller.setProvider(provider);
                        biller.setCategory(category);
                        //create child called payee1 in Payee and set the value of payee object
                        String ids = dbRef.push().getKey();
                        dbRef.child(ids).setValue(biller);
                        Toast.makeText(getApplicationContext(), "Biller saved.", Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid input for reference number.", Toast.LENGTH_SHORT).show();
                }
                //startActivity(intent);
            }
            });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        provider = spinner1.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), provider, Toast.LENGTH_SHORT).show();
        category = spinner2.getSelectedItem().toString();
        Toast.makeText(adapterView.getContext(), category, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void backToList(View view) {
        Intent intent = new Intent(this,  BilletList.class);
        Button image = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }
}

