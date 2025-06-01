package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.example.myapplication.databinding.FragmentLoginPageBinding;

public class LoginPage extends Fragment {
    private FirebaseAuth auth;
    private FragmentLoginPageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginPageBinding.inflate(inflater, container, false);
        auth = FirebaseAuth.getInstance();

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.usernameLogin.getText().toString().trim();
                String password = binding.passwordLogin.getText().toString().trim();

                if (!email.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!password.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(requireActivity(), task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getActivity(), HomeActivity.class));
                                } else {
                                    Toast.makeText(getActivity(), "Login failed: " + (task.getException() != null ? task.getException().getMessage() : "Unknown error"), Toast.LENGTH_SHORT).show();
                                }
                            });
                    } else {
                        binding.passwordLogin.setError("password cannot be empty");
                    }
                } else if (email.isEmpty()) {
                    binding.usernameLogin.setError("Email cannot be empty");
                } else {
                    binding.usernameLogin.setError("Invalid email");
                }
            }
        });

        if (binding.signupRedirect != null) {
            binding.signupRedirect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() instanceof MainActivity) {
                        ((MainActivity) getActivity()).getViewPager2().setCurrentItem(1, true);
                    }
                }
            });
        }

        return binding.getRoot();
    }
}

