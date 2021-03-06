package com.example.uee_ndb_neos_bankingapp.ui.bills;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.uee_ndb_neos_bankingapp.MainActivity;
        import com.example.uee_ndb_neos_bankingapp.R;

public class BilletList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biller_list);

    }

    public void sendToBillForm(View view) {
        Intent intent = new Intent(this,  AddBiller.class);
        ImageButton image = (ImageButton) findViewById(R.id.add);
        startActivity(intent);
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        ImageButton image = (ImageButton) findViewById(R.id.back);
        startActivity(intent);
    }
}

