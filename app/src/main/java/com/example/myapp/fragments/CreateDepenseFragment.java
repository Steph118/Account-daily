package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapp.databinding.FragmentCreateDepenseBinding;

public class CreateDepenseFragment extends Fragment {

    public static final String TAG = "createAccount";
    private FragmentCreateDepenseBinding binding;

    public CreateDepenseFragment() {
    }

    public static CreateDepenseFragment newInstance() {
        return new CreateDepenseFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateDepenseBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setCancelClick();
    }

    public  void setCancelClick(){
        binding.cancelRegisterButton.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                .navigate(CreateDepenseFragmentDirections.actionCreateAccountFragmentToHomeFragment()));
    }
}