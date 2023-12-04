package cm.iutgi.iutVote.ejb;

import cm.iutgi.iutVote.entities.Etudiant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EtudiantManager {
    
    @PersistenceContext(unitName = "iutVotePU")
    private EntityManager em;

    public List<Etudiant> getAllEtudiants() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    public Etudiant update(Etudiant etudiant) {
       return em.merge(etudiant);
    }

    public void persist(Etudiant etudiant) {
       em.persist(etudiant);
    }
    
    public void remove(Etudiant etudiant){
        em.remove(etudiant);
    }
    
    public Etudiant findEtudiant (String id, String mdp){
        Query query = em.createNamedQuery("Etudiant.findEtudiant");
        query.setParameter("id", id);
        query.setParameter("mdp", mdp);
        if(query.getResultList().isEmpty())
            return null;
        else
            return (Etudiant) query.getSingleResult();
    }
    
    public Etudiant findById (String id){
        return em.find(Etudiant.class, id);
    }
    
    public Etudiant findByMatricule (String mail){
        Query query = em.createNamedQuery("Etudiant.findByMatricule");
        query.setParameter("matricule", mail);
        if(query.getResultList().isEmpty())
            return null;
        else
            return (Etudiant) query.getSingleResult();
    }

}