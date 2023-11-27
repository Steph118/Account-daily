package com.example.myapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapp.activities.MainActivity;
import com.example.myapp.constant.FormatDate;
import com.example.myapp.databinding.FragmentCreateDepenseBinding;
import com.example.myapp.entities.Depense;
import com.example.myapp.viewmodel.CreateDepenseViewModel;
import com.example.myapp.viewmodel.InscriptionViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CreateDepenseFragment extends Fragment {

    public static final String TAG = "createAccount";
    private CreateDepenseViewModel createDepenseViewModel;

    private final MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
            .build();
    private final MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setTitleText("Select time")
            .build();
    private String libelle, depense, montant, date, time, dateTime;
    private FragmentCreateDepenseBinding binding;
    private boolean ischeck;

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
        binding = FragmentCreateDepenseBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createDepenseViewModel = new ViewModelProvider(this)
                .get(CreateDepenseViewModel.class);
        setClick();
        observer();
    }

    public void observer(){
            final Observer<Boolean> observer = isRegister -> {
                if (isRegister) {
                }
                //dismissLoadingDialog();
            };
            createDepenseViewModel.getIscreated().observe(getViewLifecycleOwner(),observer);
            /*createDepenseViewModel.getIscreated().observe(this, observer);*/
    }

    public void setClick() {
        binding.switchRegisterDate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.textInputDate.setVisibility(View.VISIBLE);
            } else {
                binding.textInputDate.setVisibility(View.GONE);
            }
        });

        binding.cancelRegisterButton.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(CreateDepenseFragmentDirections.actionCreateAccountFragmentToHomeFragment()));

        binding.registerButton.setOnClickListener(v -> {
            checkEdit();
        });

        binding.textInputDate.setEndIconOnClickListener(v -> {
            showDatePicker();
        });

        datePicker.addOnPositiveButtonClickListener(selection -> {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTimeInMillis(selection);
            date = FormatDate.datepicker(Locale.getDefault(), calendar);
            showTimePicker();
        });

        timePicker.addOnPositiveButtonClickListener(v -> {
            int newHour = timePicker.getHour();
            int newMinute = timePicker.getMinute();
            onTimeSet(newHour, newMinute);
            dateTime = date + " " + time;
            binding.editTextDate.setText(dateTime);
        });
    }

    public void checkEdit() {
        libelle = String.valueOf(binding.editTextLibelle.getText());
        montant = String.valueOf(binding.editTextMontant.getText());
        depense = String.valueOf(binding.editTextDepense.getText());
        ischeck = binding.switchRegisterDate.isChecked();
        if (isEmpty(libelle)) {
            binding.textInputDepense.setErrorEnabled(false);
            binding.textInputMontant.setErrorEnabled(false);
            binding.textInputLibelle.setErrorEnabled(true);
            binding.textInputLibelle.setError("recquis");
        } else if (isEmpty(montant)) {
            binding.textInputDepense.setErrorEnabled(false);
            binding.textInputLibelle.setErrorEnabled(false);
            binding.textInputMontant.setErrorEnabled(true);
            binding.textInputMontant.setError("recquis");
        } else if (isEmpty(depense)) {
            binding.textInputMontant.setErrorEnabled(false);
            binding.textInputLibelle.setErrorEnabled(false);
            binding.textInputDepense.setErrorEnabled(true);
            binding.textInputDepense.setError("recquis");
        } else {
            checkDateSelection(ischeck);
        }
    }

    public void checkDateSelection(boolean isChecked) {
        if (isChecked) {
            registerWithDate();
        } else {
            register();
        }
    }

    public void registerWithDate() {
        if (isEmpty(String.valueOf(binding.editTextDate.getText()))) {
            binding.textInputMontant.setErrorEnabled(false);
            binding.textInputLibelle.setErrorEnabled(false);
            binding.textInputDepense.setErrorEnabled(false);
            binding.textInputDate.setError("Date et time recquis");
        } else {
            register();
        }
    }

    public void showDatePicker() {
        datePicker.show(getParentFragmentManager(), TAG);
    }

    public void showTimePicker() {
        timePicker.show(getParentFragmentManager(), TAG);
    }

    public void register() {
        Depense depense = new Depense();
        depense.setLibelle(libelle);
        depense.setValeur(Double.valueOf(montant));
        depense.setIdMontant(12L);
        if (ischeck)
            depense.setDateDepense(dateTime);

        createDepenseViewModel.create(depense);
    }

    public boolean isEmpty(String content) {
        return content.equals("");
    }

    private void onTimeSet(int newHour, int newMinute) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, newHour);
        cal.set(Calendar.MINUTE, newMinute);
        cal.setLenient(false);
        time = FormatDate.timePicker(cal);
    }
}