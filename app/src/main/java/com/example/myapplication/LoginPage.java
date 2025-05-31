package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LoginPage extends Fragment {

    EditText username, password;
    Button loginBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        username = getActivity().findViewById(R.id.username);
        password = getActivity().findViewById(R.id.password);
        loginBtn = getActivity().findViewById(R.id.loginBtn);


        return inflater.inflate(R.layout.fragment_login_page, container, false);
    }


}