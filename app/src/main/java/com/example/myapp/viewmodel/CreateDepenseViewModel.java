package com.example.myapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.entities.Depense;
import com.example.myapp.services.ServiceWithExecutor;

public class CreateDepenseViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> iscreated;
    private final ServiceWithExecutor createDepenseService;

    public CreateDepenseViewModel(@NonNull Application application) {
        super(application);
        createDepenseService = new ServiceWithExecutor(application);
    }

    public MutableLiveData<Boolean> getDepenseMutableLiveData() {
        if (iscreated==null){
            iscreated = new MutableLiveData<>();
        }
        return iscreated;
    }

    public void setDepenseMutableLiveData(MutableLiveData<Boolean> iscreated) {
        this.iscreated = iscreated;
    }

    public MutableLiveData<Boolean> getIscreated() {
        if (iscreated==null){
            iscreated = new MutableLiveData<>();
        }
        return iscreated;
    }

    public void setIscreated(MutableLiveData<Boolean> iscreated) {
        this.iscreated = iscreated;
    }

    public void create(Depense depense){
        createDepenseService.registerDepense(depense,this.getDepenseMutableLiveData());
    }
}
