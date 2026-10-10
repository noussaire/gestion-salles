package com.example.jpa.entities;

import javax.persistence.*;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false)
    private int capacite;

    @Column(nullable = false)
    private int etage;

    @Column(nullable = false)
    private boolean equipee;

    @Column(nullable = false)
    private String batiment;

    public Salle() {}

    public Salle(String nom, int capacite, int etage, boolean equipee) {
        this(nom, capacite, etage, equipee, "Principal");
    }

    public Salle(String nom, int capacite, int etage, boolean equipee, String batiment) {
        this.nom = nom;
        this.capacite = capacite;
        this.etage = etage;
        this.equipee = equipee;
        this.batiment = batiment;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }

    public int getEtage() { return etage; }
    public void setEtage(int etage) { this.etage = etage; }

    public boolean isEquipee() { return equipee; }
    public void setEquipee(boolean equipee) { this.equipee = equipee; }

    public String getBatiment() { return batiment; }
    public void setBatiment(String batiment) { this.batiment = batiment; }

    @Override
    public String toString() {
        return "Salle [id=" + id + ", nom=" + nom + ", capacite=" + capacite
                + ", etage=" + etage + ", equipee=" + equipee + ", batiment=" + batiment + "]";
    }
}