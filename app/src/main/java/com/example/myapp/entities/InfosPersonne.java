package com.example.myapp.entities;

import androidx.annotation.NonNull;

public class InfosPersonne {
    private long id;
    private String Nom;
    private String prenom;
    private String email;
    private String telephone;
    private String photo;

    public InfosPersonne() {
    }

    public InfosPersonne(String nom, String prenom, String email, String telephone, String photo) {
        Nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @NonNull
    @Override
    public String toString() {
        return "InfosPersonne{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", photoe='" + photo + '\'' +
                '}';
    }
}
