package com.example.myapp.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapp.databinding.FragmentForgetPasswordBinding;


public class ForgetPasswordFragment extends DialogFragment {

    public static final String TAG = "FORGET_PASSWORD";
    private FragmentForgetPasswordBinding binding;

    public static ForgetPasswordFragment instance() {
        return new ForgetPasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentForgetPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        click();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = requireDialog();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        Window window = dialog.getWindow();
        window.setLayout(width, height);
        dialog.setCanceledOnTouchOutside(false);
    }

    public void click() {
        binding.cancel.setOnClickListener(v -> this.dismiss());
    }
}