package com.example.paytrack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TransactionsFragment extends Fragment {



    RecyclerView recyclerView;
    TransactionAdapter adapter;
    List<Transaction> transactionList;

    public TransactionsFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_transactions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Load sample data
        transactionList = new ArrayList<>();
        transactionList.add(new Transaction("2024-11-25", "Groceries", "$50", "Debit"));
        transactionList.add(new Transaction("2024-11-24", "Salary", "$2000", "Credit"));
        transactionList.add(new Transaction("2024-11-23", "Movie", "$30", "Debit"));

        // Set Adapter
        adapter = new TransactionAdapter(transactionList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}