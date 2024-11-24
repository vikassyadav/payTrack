package com.example.paytrack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PayFragment extends Fragment {


    TextView upiId, Amount, Note, typeOfExpanse;

    public PayFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);
        // Inflate the layout for this fragment

        upiId = view.findViewById(R.id.editUpiId);
        Amount = view.findViewById(R.id.editAmount);
        typeOfExpanse = view.findViewById(R.id.editTypeOfExpense);
        Note = view.findViewById(R.id.editNote);


        return view;


    }
}