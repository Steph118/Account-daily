package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.databinding.FragmentDemoPiWelcomeBinding;

public class DemoPiWelcomeFragment extends Fragment {
    private FragmentDemoPiWelcomeBinding binding;

    public DemoPiWelcomeFragment() {
    }

    public static DemoPiWelcomeFragment newInstance() {
        return new DemoPiWelcomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDemoPiWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setClick(view);
    }

    public void setClick(View v1) {
        /*binding.skipDemo.setOnClickListener(v -> {
            NavDirections directions = DemoFragmentDirections.actionDemoFragmentToEnrollementUserPiFragment();
            Navigation.findNavController(v1).navigate(directions);
        });*/
    }
}