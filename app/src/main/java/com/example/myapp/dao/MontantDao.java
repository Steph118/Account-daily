package com.example.myapp.dao;

import androidx.room.Dao;

import com.example.myapp.entities.Montant;
import com.example.myapp.interfaces.Crud;

@Dao
public interface MontantDao extends Crud<Montant> {
}
