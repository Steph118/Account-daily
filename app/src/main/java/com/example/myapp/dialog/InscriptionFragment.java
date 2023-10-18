package com.example.myapp.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapp.activities.MainActivity;
import com.example.myapp.databinding.FragmentInscriptionBinding;
import com.example.myapp.viewmodel.InscriptionViewModel;


public class InscriptionFragment extends DialogFragment implements LifecycleOwner {

    public static final String TAG = "InscriptionFragment";
    private LoadingDialog loadingDialog;
    private FragmentInscriptionBinding binding;
    private InscriptionViewModel inscriptionViewModel;
    private String username, password, confirm;

    public static InscriptionFragment instance() {
        return new InscriptionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentInscriptionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        click();
        observer();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = requireDialog();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(width, height);
        }
        dialog.setCanceledOnTouchOutside(false);
    }

    public void init() {
        inscriptionViewModel = new ViewModelProvider(this)
                .get(InscriptionViewModel.class);
        loadingDialog = new LoadingDialog();
    }

    public void click() {
        binding.cancel.setOnClickListener(v -> this.dismiss());
        submit();
    }

    public void observer() {
        final Observer<Boolean> observer = isRegister -> {
            if (isRegister) {
                Intent mainIntent = new Intent(requireContext(), MainActivity.class);
                startActivity(mainIntent);
                requireActivity().finish();
            }
            dismissLoadingDialog();
        };
        inscriptionViewModel.getIsEnregister().observe(this, observer);
    }

    public void submit() {
        binding.inscriSubmit.setOnClickListener(v -> verifyEdit());
    }

    public void controllerPasswordMatch(String username, String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            showLoadingDialog();
            inscriptionViewModel.enregister(
                    username,
                    password);
        } else {
            binding.editTextInscriConfirmPassword.setError("Le mot de passe n'est pas conforme");
        }
    }

    public void showLoadingDialog() {
        this.loadingDialog.show(getParentFragmentManager(), TAG);
    }

    public void dismissLoadingDialog() {
        this.loadingDialog.dismiss();
    }

    public void verifyEdit() {
        username = String.valueOf(binding.editTextInscriUsername.getText());
        password = String.valueOf(binding.editTextInscriPassword.getText());
        confirm = String.valueOf(binding.editTextInscriConfirmPassword.getText());
        if (username.equals("")) {
            binding.inscriUsername.setErrorEnabled(true);
            binding.editTextInscriUsername.setError("Champ requis");
            binding.inscriPassword.setErrorEnabled(false);
            binding.inscriConfirmPassword.setErrorEnabled(false);
        } else if (password.equals("")) {
            binding.inscriPassword.setErrorEnabled(true);
            binding.editTextInscriPassword.setError("Champ requis");
            binding.inscriConfirmPassword.setErrorEnabled(false);
            binding.inscriUsername.setErrorEnabled(false);
        } else if (confirm.equals("")) {
            binding.inscriConfirmPassword.setErrorEnabled(true);
            binding.editTextInscriConfirmPassword.setError("Champ requis");
            binding.inscriPassword.setErrorEnabled(false);
            binding.inscriUsername.setErrorEnabled(false);
        } else {
            username = String.valueOf(binding.editTextInscriUsername.getText());
            password = String.valueOf(binding.editTextInscriPassword.getText());
            confirm = String.valueOf(binding.editTextInscriConfirmPassword.getText());
            controllerPasswordMatch(username, password, confirm);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}