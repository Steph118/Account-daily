package com.example.myapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;

public class EnrollementUserPiFragment extends Fragment {

    public EnrollementUserPiFragment() {
        // Required empty public constructor
    }

    public static EnrollementUserPiFragment newInstance(String param1, String param2) {
        return new EnrollementUserPiFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enrollement_user_pi, container, false);
    }
}