package com.example.jpa;

import com.example.jpa.entities.Salle;
import com.example.jpa.entities.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Salle salle = new Salle("Salle A", 10, 1, true, "Bâtiment A");
            em.persist(salle);

            Utilisateur utilisateur = new Utilisateur("Dupont", "Jean", "jean.dupont@example.com", "0601020304", 28, salle);
            em.persist(utilisateur);

            tx.commit();
            System.out.println("Salle enregistrée : " + salle);
            System.out.println("Utilisateur enregistré : " + utilisateur);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}