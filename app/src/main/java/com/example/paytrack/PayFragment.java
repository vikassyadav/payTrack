package com.example.paytrack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import dev.shreyaspatil.easyupipayment.EasyUpiPayment;
import dev.shreyaspatil.easyupipayment.exception.AppNotFoundException;
import dev.shreyaspatil.easyupipayment.listener.PaymentStatusListener;

public class PayFragment extends Fragment {

    TextView upiId, Amount, Note, typeOfExpanse;
    Button payBtn;

    public PayFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState());
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pay, container, false);

        // Initialize Views
        upiId = view.findViewById(R.id.editUpiId);
        Amount = view.findViewById(R.id.editAmount);
        typeOfExpanse = view.findViewById(R.id.editTypeOfExpense);
        Note = view.findViewById(R.id.editNote);
        payBtn = view.findViewById(R.id.buttonPay); // Corrected Button ID

        // Set OnClickListener for the Pay button
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    paymentGatewayStart();
                } catch (AppNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return view;
    }

    // Payment Gateway Method
//    private void paymentGatewayStart() throws AppNotFoundException {
//        if (getActivity() == null) {
//            return; // Handle null case for activity
//        }
//
//        EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder(getActivity())
//                .setPayeeName("Vikas")
//                .setPayeeVpa(upiId.getText().toString()) // Use UPI ID from user input
//                .setDescription(Note.getText().toString()) // Use Note from user input
//                .setAmount(Amount.getText().toString()) // Use Amount from user input
//                .setTransactionId(String.valueOf(System.currentTimeMillis()))
//                .setTransactionRefId("txnRefId123");
//
//        // Build the UPI Payment
//        EasyUpiPayment upi = builder.build();
//        upi.startPayment();
//    }

    private void paymentGatewayStart() throws AppNotFoundException {
        if (getActivity() == null) {
            return; // Handle null case for activity
        }

        // Get the user input
        String upi = upiId.getText().toString().trim();
        String amount = Amount.getText().toString().trim();
        String note = Note.getText().toString().trim();

        // Check for valid inputs
        if (upi.isEmpty() || amount.isEmpty() || note.isEmpty()) {
            // Handle empty fields, show a toast or log a message
            Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return; // Exit if any field is empty
        }

        // Proceed with the payment gateway if all fields are valid
        EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder(getActivity())
                .setPayeeName("Vikas")
                .setPayeeMerchantCode("5812")
                .setPayeeVpa(upi) // Use UPI ID from user input
                .setDescription(note) // Use Note from user input
                .setAmount(amount) // Use Amount from user input
                .setTransactionId(String.valueOf(System.currentTimeMillis()))
                .setTransactionRefId("txnRefId123");

        // Build the UPI Payment
        EasyUpiPayment upiPayment = builder.build();
        upiPayment.startPayment();

        // Build instance
//        EasyUpiPayment easyUpiPayment = builder.build();
//
//        // Register Listener for Events
//        easyUpiPayment.setPaymentStatusListener((PaymentStatusListener) getActivity());
//
//        // Start payment / transaction
//        easyUpiPayment.startPayment();
    }

}
