package com.example.jpa.test;

import com.example.jpa.entities.Salle;
import com.example.jpa.entities.Utilisateur;
import com.example.jpa.service.ServiceGestion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceGestionTest {

    private ServiceGestion service;

    @Before
    public void setUp() {
        service = new ServiceGestion();
    }

    @After
    public void tearDown() {
        service.fermer();
    }

    @Test
    public void testCreationEtRechercheSalle() {
        Salle salle = new Salle("Salle Test", 20, 2, true);
        service.ajouterSalle(salle);

        List<Salle> salles = service.listerSalles();
        assertFalse(salles.isEmpty());

        Salle trouvee = salles.stream()
                .filter(s -> s.getNom().equals("Salle Test"))
                .findFirst().orElse(null);
        assertNotNull(trouvee);
        assertEquals(20, trouvee.getCapacite());
        assertEquals(2, trouvee.getEtage());
        assertTrue(trouvee.isEquipee());
    }

    @Test
    public void testCreationUtilisateurAvecSalle() {
        Salle salle = new Salle("Salle B", 15, 1, false);
        service.ajouterSalle(salle);

        Utilisateur utilisateur = new Utilisateur("Alice", "alice@example.com", "0600000000", 25, salle);
        service.ajouterUtilisateur(utilisateur);

        Utilisateur trouve = service.listerUtilisateurs().stream()
                .filter(u -> u.getEmail().equals("alice@example.com"))
                .findFirst().orElse(null);
        assertNotNull(trouve);
        assertEquals("Alice", trouve.getNom());
        assertEquals("0600000000", trouve.getTelephone());
        assertEquals(25, trouve.getAge());
        assertEquals("Salle B", trouve.getSalle().getNom());
    }

    @Test
    public void testRechercheUtilisateursParSalle() {
        Salle salle = new Salle("Salle C", 30, 3, true);
        service.ajouterSalle(salle);

        Utilisateur u1 = new Utilisateur("Bob", "bob@example.com", "0611111111", 30, salle);
        Utilisateur u2 = new Utilisateur("Carol", "carol@example.com", "0622222222", 28, salle);
        service.ajouterUtilisateur(u1);
        service.ajouterUtilisateur(u2);

        List<Utilisateur> utilisateurs = service.utilisateursParSalle("Salle C");
        assertEquals(2, utilisateurs.size());
    }
}