package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapp.R;

public class DashbordPiFragment extends Fragment {

    public DashbordPiFragment() {
        // Required empty public constructor
    }

    public static DashbordPiFragment newInstance(String param1, String param2) {
        return new DashbordPiFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashbord_pi, container, false);
    }
}