package com.example.myapp.dao;

import androidx.room.Dao;

import com.example.myapp.entities.InfosPersonne;
import com.example.myapp.interfaces.Crud;

import java.util.List;

@Dao
public interface InfosPersonneDao extends Crud<InfosPersonne> {
}
