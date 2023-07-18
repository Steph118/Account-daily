package com.example.myapp.entities;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Montant {

    private long id;
    private double valeur;
    private boolean status;
    private String dateCreation;
    private List<Depense> depenses = new ArrayList<>();


    public Montant() {
    }

    public Montant(double valeur, boolean status, String dateCreation) {
        this.valeur = valeur;
        this.status = status;
        this.dateCreation = dateCreation;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
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
