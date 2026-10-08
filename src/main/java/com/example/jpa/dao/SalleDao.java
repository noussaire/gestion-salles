package com.example.jpa.dao;

import com.example.jpa.entities.Salle;
import javax.persistence.EntityManager;
import java.util.List;

public class SalleDao extends GenericDao<Salle> {

    public SalleDao(EntityManager em) {
        super(Salle.class, em);
    }

    public List<Salle> findByCapaciteMin(int capaciteMin) {
        return em.createQuery("SELECT s FROM Salle s WHERE s.capacite >= :capaciteMin", Salle.class)
                .setParameter("capaciteMin", capaciteMin)
                .getResultList();
    }

    public List<Salle> findByEtage(int etage) {
        return em.createQuery("SELECT s FROM Salle s WHERE s.etage = :etage", Salle.class)
                .setParameter("etage", etage)
                .getResultList();
    }

    public List<Salle> findByCapaciteSuperieure(int minCapacite) {
        return em.createQuery("SELECT s FROM Salle s WHERE s.capacite > :minCapacite", Salle.class)
                .setParameter("minCapacite", minCapacite)
                .getResultList();
    }
}