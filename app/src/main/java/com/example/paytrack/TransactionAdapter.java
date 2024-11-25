package com.example.paytrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private final List<Transaction> transactionList;

    public TransactionAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_item, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        holder.date.setText(transaction.getDate());
        holder.description.setText(transaction.getDescription());
        holder.amount.setText(transaction.getAmount());
        holder.type.setText(transaction.getType());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {
        TextView date, description, amount, type;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.text_date);
            description = itemView.findViewById(R.id.text_description);
            amount = itemView.findViewById(R.id.text_amount);
            type = itemView.findViewById(R.id.text_type);
        }
    }
}
