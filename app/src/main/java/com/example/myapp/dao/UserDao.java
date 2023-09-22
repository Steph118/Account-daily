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

    @Query("delete from users")
    void deleteAll();

    @Query("select * from users where username = :username and password = :password")
    User getOne(String username, String password);

    default boolean verifyLogin(String username, String password) {
        return getOne(username, password) != null;
    }

    default boolean haveAccount() {
        return (!getAll().isEmpty());
    }
}
