package com.example.myapp.dao;

import java.util.ArrayList;

public interface Crud<Object> {

    long add(Object object);
    int delete(long id);
    int update(Object object);
    Object getOne(long id);
    ArrayList<Object> getAll();
}
