package com.example.myapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.repository.LoginRepository;

public class LoginViewModel extends AndroidViewModel {

    private final LoginRepository loginRepository;
    private MutableLiveData<Boolean> verify = new MutableLiveData<>();

    public LoginViewModel(Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }

    public MutableLiveData<Boolean> getVerify() {
        if (verify == null) {
            verify = new MutableLiveData<>();
        }
        return verify;
    }
}
