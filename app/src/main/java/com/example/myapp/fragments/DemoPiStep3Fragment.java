package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapp.R;

public class DemoPiStep3Fragment extends Fragment {

    public DemoPiStep3Fragment() {
    }

    public static DemoPiStep3Fragment newInstance() {
        return new DemoPiStep3Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo_pi_step3, container, false);
    }
}