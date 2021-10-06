package com.example.uee_ndb_neos_bankingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistationFragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistationFragmentTwo extends Fragment {

    Button button;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistationFragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistationFragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistationFragmentTwo newInstance(String param1, String param2) {
        RegistationFragmentTwo fragment = new RegistationFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view;
        view = inflater.inflate(R.layout.fragment_registation_two, container, false);

        CheckBox checkBox3 = view.findViewById(R.id.chkf2final);

        button=view.findViewById(R.id.buttonf2final);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RK_registered_user_daily_login.class);

                editText1 = view.findViewById(R.id.cardnf1o1);
                String message1 = editText1.getText().toString();
                //Trim whitespace
                message1 = message1.trim();

                editText2 = view.findViewById(R.id.cdexpf2);
                String message2 = editText2.getText().toString();
                //Trim whitespace
                message2 = message2.trim();

                editText3 = view.findViewById(R.id.ccvf2);
                String message3 = editText3.getText().toString();
                //Trim whitespace
                message3 = message3.trim();

                editText4 = view.findViewById(R.id.atmpinf2);
                String message4 = editText4.getText().toString();
                //Trim whitespace
                message4 = message4.trim();

                editText5 = view.findViewById(R.id.usnf2);
                String message5 = editText5.getText().toString();
                //Trim whitespace
                message5 = message5.trim();

                editText6 = view.findViewById(R.id.pwdf2);
                String message6 = editText6.getText().toString();
                //Trim whitespace
                message6 = message6.trim();


                if (message1.length() == 0) {
                    editText1.setError("Can't be the Card Number empty!");
                }
                else if (message2.length() == 0) {
                    editText2.setError("Can't be the Expiry Date empty!");
                }
                else if (message3.length() == 0) {
                    editText3.setError("Can't be the CCV empty!");
                }
                else if (message4.length() == 0) {
                    editText4.setError("Can't be the ATM PIN empty!");
                }
                else if (message5.length() == 0) {
                    editText5.setError("Can't be the App User Name empty!");
                }
                else if (message6.length() == 0) {
                    editText6.setError("Can't be the App Password empty!");
                }
                else if (!checkBox3.isChecked()) {
                    checkBox3.setError("You have to agree with this!");
                }
                else {
                        startActivity(intent);
                }

            }

        });

        return view;

    }
}