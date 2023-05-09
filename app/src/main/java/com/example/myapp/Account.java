package com.example.myapp;

public class Account {

    private double montant;
    private double depense;
    private double reste;

    private String Date;

    public Account() {
    }

    public Account(double montant, double depense, double reste, String date) {
        this.montant = montant;
        this.depense = depense;
        this.reste = reste;
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }
}
