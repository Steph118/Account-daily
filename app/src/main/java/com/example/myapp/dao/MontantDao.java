package com.example.myapp.dao;

import androidx.room.Dao;

import com.example.myapp.entities.Montant;

@Dao
public interface MontantDao extends Crud<Montant, Long> {
}
