package com.example.uee_ndb_neos_bankingapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uee_ndb_neos_bankingapp.ContactUs;
import com.example.uee_ndb_neos_bankingapp.DashboardBrief;
import com.example.uee_ndb_neos_bankingapp.R;
import com.example.uee_ndb_neos_bankingapp.RKInitialLandingOne;
import com.example.uee_ndb_neos_bankingapp.databinding.FragmentHomeBinding;
import com.example.uee_ndb_neos_bankingapp.ui.bills.BillPaymentForm;
import com.example.uee_ndb_neos_bankingapp.ui.fund.Credit_card_details;
import com.example.uee_ndb_neos_bankingapp.ui.fund.FundMain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    // imageview view variable

    ImageButton ibtn1 ;
    CardView creditCard;
    ImageButton ibtn2;
    FloatingActionButton fab1;
    ImageButton RKibtn01 ;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //


        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RKibtn01 = root.findViewById(R.id.imageButton23);
        creditCard = root.findViewById(R.id.cardView2);
        ibtn1 = root.findViewById(R.id.imageButton22);//For fund transaction
        ibtn2 = root.findViewById(R.id.imageButton19);//For bill payment
        fab1 = root.findViewById(R.id.floatingActionButton);

        creditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Credit_card_details.class);
                startActivity(intent);
            }
        });

        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FundMain.class);
                startActivity(intent);

            }
        });

        ibtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BillPaymentForm.class);
                startActivity(intent);
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DashboardBrief.class);
                startActivity(intent);
            }
        });

        RKibtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactUs.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}