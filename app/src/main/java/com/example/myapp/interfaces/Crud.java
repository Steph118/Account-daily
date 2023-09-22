package com.example.myapp.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.io.Serializable;
import java.util.List;

@Dao
public interface Crud<Entity extends Serializable> {
    @Insert
    void insert(Entity entity);

    @Insert
    void insert(List<Entity> entities);

    @Update
    void update(Entity entity);

    @Update
    void update(List<Entity> entities);

    @Delete
    void delete(Entity entity);

    @Delete
    void delete(List<Entity> entities);
}
