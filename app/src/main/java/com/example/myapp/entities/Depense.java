package com.example.myapp.entities;

import androidx.annotation.NonNull;

public class Depense {
    private long id;
    private double valeur;
    private String libelle;
    private String dateDepense;
    private Montant montant;

    public Depense() {
    }

    public Depense(double valeur, String libelle, String dateDepense, Montant montant) {
        this.valeur = valeur;
        this.libelle = libelle;
        this.dateDepense = dateDepense;
        this.montant = montant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(String dateDepense) {
        this.dateDepense = dateDepense;
    }

    public Montant getMontant() {
        return montant;
    }

    public void setMontant(Montant montant) {
        this.montant = montant;
    }

    @NonNull
    @Override
    public String toString() {
        return "Depense{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", libelle='" + libelle + '\'' +
                ", dateDepense='" + dateDepense + '\'' +
                ", montant=" + montant +
                '}';
    }
}
