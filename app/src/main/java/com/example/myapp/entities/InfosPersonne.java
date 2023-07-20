package com.example.myapp.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "infos_personnes",
        indices = {@Index(value = "email",unique = true)})
public class InfosPersonne {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "nom")
    private String Nom;
    @ColumnInfo(name = "prenom")
    private String prenom;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "telephone")
    private String telephone;
    @ColumnInfo(name = "autre_telephone")
    private String autreTelephone;
    @ColumnInfo(name = "photo")
    private String photo;
    @ColumnInfo(name = "id_user")
    private Long idUser;

    public InfosPersonne() {
    }

    @Ignore
    public InfosPersonne(Long id, String nom, String prenom, String email, String telephone, String photo, Long idUser,String autreTelephone) {
        this.id = id;
        Nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.autreTelephone = autreTelephone;
        this.photo = photo;
        this.idUser = idUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getAutreTelephone() {
        return autreTelephone;
    }

    public void setAutreTelephone(String autreTelephone) {
        this.autreTelephone = autreTelephone;
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
                ", autreTelephone='" + autreTelephone + '\'' +
                ", photo='" + photo + '\'' +
                ", idUser='" + idUser + '\'' +
                '}';
    }
}
