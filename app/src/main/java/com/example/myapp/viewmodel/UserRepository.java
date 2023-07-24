package com.example.myapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.myapp.dao.UserDao;
import com.example.myapp.database.AppDatabase;
import com.example.myapp.entities.User;

public class UserRepository {
    UserDao userDao;

    public UserRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        this.userDao = appDatabase.userDao();
    }
}
