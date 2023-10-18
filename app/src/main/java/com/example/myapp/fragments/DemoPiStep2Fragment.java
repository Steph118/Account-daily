package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapp.R;

public class DemoPiStep2Fragment extends Fragment {

    public DemoPiStep2Fragment() {
        // Required empty public constructor
    }

    public static DemoPiStep2Fragment newInstance() {
        return new DemoPiStep2Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo_pi_step2, container, false);
    }
}