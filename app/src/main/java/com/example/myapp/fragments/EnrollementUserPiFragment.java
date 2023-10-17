package com.example.myapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.databinding.FragmentEnrollementUserPiBinding;

public class EnrollementUserPiFragment extends Fragment {
    private FragmentEnrollementUserPiBinding binding;

    public EnrollementUserPiFragment() {
        // Required empty public constructor
    }

    public static EnrollementUserPiFragment newInstance() {
        return new EnrollementUserPiFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEnrollementUserPiBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}