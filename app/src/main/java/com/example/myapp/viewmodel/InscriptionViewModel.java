package com.example.myapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.repository.InscriptionRepository;

public class InscriptionViewModel extends AndroidViewModel {
    private final InscriptionRepository inscriptionRepository;
    private MutableLiveData<String> username;
    private MutableLiveData<String> password;
    private MutableLiveData<Boolean> isEnregister = new MutableLiveData<>();

    public InscriptionViewModel(Application application) {
        super(application);
        inscriptionRepository = new InscriptionRepository(application);
    }


    public MutableLiveData<String> getUsername() {
        if (username == null) {
            username = new MutableLiveData<>();
        }
        return username;
    }

    public MutableLiveData<String> getPassword() {
        if (password == null) {
            password = new MutableLiveData<>();
        }
        return password;
    }

    public MutableLiveData<Boolean> getIsEnregister() {
        if (isEnregister == null) {
            isEnregister = new MutableLiveData<>();
        }
        return isEnregister;
    }

    public void setIsEnregister(MutableLiveData<Boolean> isEnregister) {
        this.isEnregister = isEnregister;
    }

    public void enregister(String username, String password) {
        this.getUsername().setValue(username);
        this.getPassword().setValue(password);
        inscriptionRepository.register(this.username.getValue(), this.password.getValue(), isEnregister);
    }
}
