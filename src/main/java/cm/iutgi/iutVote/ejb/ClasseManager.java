/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package cm.iutgi.iutVote.ejb;

import cm.iutgi.iutVote.entities.Classe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saims
 */
@Stateless
public class ClasseManager {
    @PersistenceContext(unitName = "iutVotePU")
    private EntityManager em;

    public Classe findByName(String nom) {
        Query query = em.createNamedQuery("Classe.findByNom");
        query.setParameter("nom", nom);
        if(query.getResultList().isEmpty())
            return null;
        else
            return (Classe) query.getSingleResult();
    }
}
