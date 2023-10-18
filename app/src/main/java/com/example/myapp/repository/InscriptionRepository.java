package com.example.myapp.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.myapp.dao.UserDao;
import com.example.myapp.database.AppDatabase;
import com.example.myapp.entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InscriptionRepository {
    /*    ThreadPoolExecutor threadPoolExecutor;
        FutureTask futureTask;*/
    private final ExecutorService executor = Executors.newFixedThreadPool(1);
    private final UserDao userDao;

    public InscriptionRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);
        userDao = database.userDao();
    }

    public void register(String username, String password,
                         MutableLiveData<Boolean> isEnregister) {
        /*Callable<Boolean> callable = () -> {
            try {
                User user = new User(username, password);
                userDao.insert(user);
                isEnregister.postValue(Boolean.FALSE);
            } catch (Exception e) {
                isEnregister.postValue(Boolean.FALSE);
            }
            return isEnregister.getValue();
        };*/
        Runnable runnable = () -> {
            try {
                User user = new User(username, password);
                userDao.insert(user);
                isEnregister.postValue(Boolean.TRUE);
            } catch (Exception e) {
                isEnregister.postValue(Boolean.FALSE);
            }
        };
        executor.submit(runnable);
        //executor.submit(callable);
    }
}
