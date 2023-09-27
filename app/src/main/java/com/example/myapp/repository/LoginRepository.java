package com.example.myapp.repository;

import android.app.Application;

import com.example.myapp.dao.UserDao;
import com.example.myapp.database.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginRepository {

    private static final int NUMBER_OF_THREADS = 1;
    static final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private UserDao userDao;

    public LoginRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);
        userDao = database.userDao();
    }
}
