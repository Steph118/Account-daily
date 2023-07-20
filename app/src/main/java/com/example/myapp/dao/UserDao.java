package com.example.myapp.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.myapp.entities.User;
import com.example.myapp.interfaces.Crud;

import java.util.List;

@Dao
public interface UserDao extends Crud<User> {

    @Query("select * from users")
    List<User> getAll();
}
