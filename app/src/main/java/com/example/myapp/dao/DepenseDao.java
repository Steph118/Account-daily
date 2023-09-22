package com.example.myapp.dao;

import androidx.room.Dao;

import com.example.myapp.entities.Depense;
import com.example.myapp.interfaces.Crud;

@Dao
public interface DepenseDao extends Crud<Depense> {

}
