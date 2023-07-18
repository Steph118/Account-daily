package com.example.myapp.entities;

import androidx.annotation.NonNull;

public class User {
    private long id;
    private String username;
    private String password;
    private InfosPersonne infosPersonne;

    public User() {
    }

    public User(String username, String password, InfosPersonne infosPersonne) {
        this.username = username;
        this.password = password;
        this.infosPersonne = infosPersonne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InfosPersonne getInfosPersonne() {
        return infosPersonne;
    }

    public void setInfosPersonne(InfosPersonne infosPersonne) {
        this.infosPersonne = infosPersonne;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", infosPersonne=" + infosPersonne +
                '}';
    }
}
