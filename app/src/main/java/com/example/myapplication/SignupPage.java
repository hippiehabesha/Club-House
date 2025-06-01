package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.example.myapplication.databinding.FragmentSigninPageBinding;

public class SignupPage extends Fragment {

   private FirebaseAuth auth;
   private FragmentSigninPageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSigninPageBinding.inflate(inflater, container, false);
        auth = FirebaseAuth.getInstance();

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.usernameSignup.getText().toString().trim();
                String password = binding.passwordSignup.getText().toString().trim();

                if (!email.isEmpty() && !password.isEmpty()) {
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(requireActivity(), task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_SHORT).show();
                                if (getActivity() instanceof MainActivity) {
                                    ((MainActivity) getActivity()).getViewPager2().setCurrentItem(0, true);
                                }
                            } else {
                                Toast.makeText(getActivity(), "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                }
            }
        });

        binding.loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).getViewPager2().setCurrentItem(0, true);
                }
            }
        });

        return binding.getRoot();
    }
}

