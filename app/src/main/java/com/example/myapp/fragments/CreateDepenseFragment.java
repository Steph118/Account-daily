package com.example.myapp.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapp.R;
import com.example.myapp.constant.FormatDate;
import com.example.myapp.databinding.FragmentCreateDepenseBinding;
import com.example.myapp.entities.Depense;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class CreateDepenseFragment extends Fragment {

    public static final String TAG = "createAccount";
    private String libelle, depense, montant, date, time;
    private FragmentCreateDepenseBinding binding;
    private boolean ischeck;
    private final MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
            .build();
    private final MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(0)
            .setMinute(0)
            .setTitleText("Select time")
            .build();

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
        setClick();
    }

    public  void setClick(){
        swicthDateClick();
        binding.cancelRegisterButton.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                .navigate(CreateDepenseFragmentDirections.actionCreateAccountFragmentToHomeFragment()));
        binding.registerButton.setOnClickListener(v -> {
            checkEdit();
        });

       binding.textInputDate.setEndIconOnClickListener(v -> {
           displayDatePicker();
       });

       datePicker.addOnPositiveButtonClickListener(selection -> {
           Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
           calendar.setTimeInMillis(selection);
           date = FormatDate.datepicker(Locale.getDefault(),calendar);
           displayTimePicker();
       });

       timePicker.addOnPositiveButtonClickListener(v -> {
           int newHour = timePicker.getHour();
           int newMinute = timePicker.getMinute();
           onTimeSet(newHour, newMinute);
           binding.editTextDate.setText(date + " " + time);
       });
    }


    public void test(){
        List<Depense> depenses = new ArrayList<>();
        depenses.add(new Depense(12.25,"ss","ss",12L));
        ArrayAdapter<Depense> adapter = new ArrayAdapter<>(
        requireContext(),R.layout.test,depenses
        );
        binding.editTextDate.setAdapter(adapter);
    }

    public void checkEdit(){
        libelle = String.valueOf(binding.editTextLibelle.getText());
        montant = String.valueOf(binding.editTextMontant.getText());
        depense = String.valueOf(binding.editTextDepense.getText());
        ischeck = binding.switchRegisterDate.isChecked();
        if (isEmpty(libelle)){
            binding.textInputDepense.setErrorEnabled(false);
            binding.textInputMontant.setErrorEnabled(false);
            binding.textInputLibelle.setErrorEnabled(true);
            binding.textInputLibelle.setError("recquis");
        } else if (isEmpty(montant)) {
            binding.textInputDepense.setErrorEnabled(false);
            binding.textInputLibelle.setErrorEnabled(false);
            binding.textInputMontant.setErrorEnabled(true);
            binding.textInputMontant.setError("recquis");
        }else if (isEmpty(depense)){
            binding.textInputMontant.setErrorEnabled(false);
            binding.textInputLibelle.setErrorEnabled(false);
            binding.textInputDepense.setErrorEnabled(true);
            binding.textInputDepense.setError("recquis");
        }else{
            checkDateSelection(ischeck);
        }
    }

    public void checkDateSelection(boolean isChecked){
        if (isChecked){
            //String value =String.valueOf( binding.editTextDate.getText());
            if (isEmpty("")){
                binding.textInputMontant.setErrorEnabled(false);
                binding.textInputLibelle.setErrorEnabled(false);
                binding.textInputDepense.setErrorEnabled(false);
                binding.textInputDate.setError("recquis");
            }else{
                register();
            }
        }
    }

    public void register(){
    }
    public boolean isEmpty(String content){
        return content.equals("");
    }

    public void swicthDateClick(){
        binding.switchRegisterDate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                binding.textInputDate.setVisibility(View.VISIBLE);
            }else{
                binding.textInputDate.setVisibility(View.GONE);
            }
        });
    }

    public void displayDatePicker(){
        datePicker.show(getParentFragmentManager(),TAG);
    }
    public void dismissDatePicker(){
        datePicker.dismiss();
    }
    public void displayTimePicker(){
        timePicker.show(getParentFragmentManager(),TAG);
    }
    private void onTimeSet(int newHour, int newMinute) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, newHour);
        cal.set(Calendar.MINUTE, newMinute);
        cal.setLenient(false);
        time = FormatDate.timePicker(cal);
    }
}