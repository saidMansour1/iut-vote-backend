/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package cm.iutgi.iutVote.ejb;

import cm.iutgi.iutVote.entities.Admin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saims
 */
@Stateless
public class AdminManager {
    
    @PersistenceContext(unitName = "iutVotePU")
    private EntityManager em;
   

    public Admin update(Admin admin) {
       return em.merge(admin);
    }

    public void persist(Admin admin) {
       em.persist(admin);
    }
    
    public Admin findAdmin (String id, String mdp){
        Query query = em.createNamedQuery("Admin.findAdmin");
        query.setParameter("id", id);
        query.setParameter("mdp", mdp);
        if(query.getResultList().isEmpty())
            return null;
        else
            return (Admin) query.getSingleResult();
    }
    
    public Admin findById (String id){
        return em.find(Admin.class, id);
    }
    
    public Admin findByMail (String mail){
        Query query = em.createNamedQuery("Admin.findByMail");
        query.setParameter("mail", mail);
        if(query.getResultList().isEmpty())
            return null;
        else
            return (Admin) query.getSingleResult();
    }
}
