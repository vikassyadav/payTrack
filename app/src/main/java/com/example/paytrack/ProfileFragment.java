package com.example.paytrack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView profilePicture = view.findViewById(R.id.profile_picture);
        TextView profileName = view.findViewById(R.id.profile_name);
        TextView profileEmail = view.findViewById(R.id.profile_email);
        TextView profilePhone = view.findViewById(R.id.profile_phone);
        Button editProfile = view.findViewById(R.id.btn_edit_profile);
        Button logout = view.findViewById(R.id.btn_logout);

        // Set dynamic data (Replace with actual user data)
        profileName.setText("John Doe");
        profileEmail.setText("johndoe@example.com");
        profilePhone.setText("+1 234 567 890");

        // Handle button clicks
        editProfile.setOnClickListener(v -> {
            // Navigate to Edit Profile Screen
        });

        logout.setOnClickListener(v -> {
            // Perform logout logic
        });

        return view;
    }

}