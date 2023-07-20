package com.example.myapp.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "montants")
public class Montant {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;
    @ColumnInfo(name = "valeur",index = true)
    private Double valeur;
    @ColumnInfo(name = "status",index = true)
    private Boolean status;
    @ColumnInfo(name = "date_creation",index = true)
    private String dateCreation;
    @Ignore
    private List<Depense> depenses = new ArrayList<>();

    public Montant() {
    }

    @Ignore
    public Montant(Long id, Double valeur, Boolean status, String dateCreation, List<Depense> depenses) {
        this.id = id;
        this.valeur = valeur;
        this.status = status;
        this.dateCreation = dateCreation;
        this.depenses = depenses;
    }

    @Ignore
    public Montant(Double valeur, Boolean status, String dateCreation) {
        this.valeur = valeur;
        this.status = status;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }

    @NonNull
    @Override
    public String toString() {
        return "Montant{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", status=" + status +
                ", dateCreation='" + dateCreation + '\'' +
                ", depenses=" + depenses +
                '}';
    }
}
