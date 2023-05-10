package com.example.myapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class DAOBase {

    public final static int VERSION = 6;

    public final static String DATABASE = "myApp.db";
    protected SQLiteDatabase db = null;
    protected SQLiteOpenHelper handler = null;
    Context context;

    public DAOBase(Context context) {
        this.context = context ;
    }

    public SQLiteDatabase open() {
        db = handler.getWritableDatabase();
        return db;
    }

    public void close() {
        if (db!=null) db.close();
    }

    public SQLiteDatabase getDb() {
        if (db == null) return open() ;
        return db;
    }
}
