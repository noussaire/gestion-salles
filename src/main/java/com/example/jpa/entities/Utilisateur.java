package com.example.jpa.entities;

import javax.persistence.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public Utilisateur() {}

    public Utilisateur(String nom, String email, String telephone, int age, Salle salle) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
        this.salle = salle;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Salle getSalle() { return salle; }
    public void setSalle(Salle salle) { this.salle = salle; }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email
                + ", telephone=" + telephone + ", age=" + age
                + ", salle=" + (salle != null ? salle.getNom() : "aucune") + "]";
    }
}