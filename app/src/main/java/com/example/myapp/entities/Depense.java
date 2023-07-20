package com.example.myapp.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "depenses")
public class Depense {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;
    @ColumnInfo(name = "valeur",index = true)
    private Double valeur;
    @ColumnInfo(name = "libelle",index = true)
    private String libelle;
    @ColumnInfo(name = "date_depense",index = true)
    private String dateDepense;
    @ColumnInfo(name = "id_montant",index = true)
    private Long idMontant;

    public Depense() {
    }

    @Ignore
    public Depense(double valeur, String libelle, String dateDepense, Long montant) {
        this.valeur = valeur;
        this.libelle = libelle;
        this.dateDepense = dateDepense;
        this.idMontant = montant;
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

    public Long getIdMontant() {
        return idMontant;
    }

    public void setIdMontant(Long idMontant) {
        this.idMontant = idMontant;
    }

    @NonNull
    @Override
    public String toString() {
        return "Depense{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", libelle='" + libelle + '\'' +
                ", dateDepense='" + dateDepense + '\'' +
                ", montant=" + idMontant +
                '}';
    }
}
