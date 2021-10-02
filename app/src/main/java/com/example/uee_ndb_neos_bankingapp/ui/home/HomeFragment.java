package com.example.uee_ndb_neos_bankingapp.ui.home;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.uee_ndb_neos_bankingapp.DashboardBrief;
import com.example.uee_ndb_neos_bankingapp.R;
import com.example.uee_ndb_neos_bankingapp.databinding.FragmentHomeBinding;
import com.example.uee_ndb_neos_bankingapp.ui.fund.FundPayeeList;
import com.example.uee_ndb_neos_bankingapp.ui.fund.FundTransactionForm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.Activity;



public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    // imageview view variable

    ImageButton ibtn1 ;
    FloatingActionButton fab1;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //


        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ibtn1 = root.findViewById(R.id.imageButton19);
        fab1 = root.findViewById(R.id.floatingActionButton);


        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FundPayeeList.class);
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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}