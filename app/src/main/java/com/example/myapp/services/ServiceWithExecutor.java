package com.example.myapp.services;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.myapp.dao.DepenseDao;
import com.example.myapp.dao.MontantDao;
import com.example.myapp.database.AppDatabase;
import com.example.myapp.entities.Depense;
import com.example.myapp.entities.Montant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceWithExecutor {
    private final AppDatabase appDatabase;
    private final ExecutorService executor = Executors.newFixedThreadPool(1);

    public ServiceWithExecutor(Context context) {
        this.appDatabase = AppDatabase.getDatabase(context);
    }

    public void registerDepense(Depense depense,MutableLiveData<Boolean> iscreated){
        Runnable runnable = () -> {
            try {
                DepenseDao depenseDao = this.appDatabase.depenseDao();
                depenseDao.insert(depense);
                iscreated.postValue(Boolean.TRUE);
            } catch (Exception e) {
                iscreated.postValue(Boolean.FALSE);
            }
        };
        executor.submit(runnable);
    }
    public void registerMontant(Montant montant, MutableLiveData<Boolean> iscreated){
        Runnable runnable = () -> {
            try {
                MontantDao montantDao = this.appDatabase.montantDao();
                montantDao.insert(montant);
                iscreated.postValue(Boolean.TRUE);
            } catch (Exception e) {
                iscreated.postValue(Boolean.FALSE);
            }
        };
        executor.submit(runnable);
    }

}
