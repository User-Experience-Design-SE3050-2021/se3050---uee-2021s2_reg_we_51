package com.example.uee_ndb_neos_bankingapp.ui.fund;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_ndb_neos_bankingapp.MainActivity;
import com.example.uee_ndb_neos_bankingapp.R;

public class FundTransactionForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button fundbuton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_transaction_form);

        fundbuton = (Button) findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        fundbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Uncomment the below code to Set the message and title from the strings.xml file
               // builder.setMessage("messageee") .setTitle("R.string.dialog_title");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Pay ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //finish();

                                Intent intent = new Intent(getApplicationContext(),  MainActivity.class);

                                Toast.makeText(getApplicationContext(),"Paid",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(intent);
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
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });



        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.payee_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void sendToOneTimeFundTRanfer(View view) {
        Intent intent = new Intent(this,  FundTransactionOneTime.class);
        Button button = (Button) findViewById(R.id.button2);
        startActivity(intent);
    }
    public void sendToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);


        //startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
