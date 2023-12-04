/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cm.iutgi.iutVote.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author saims
 */
@Entity
@Table(name = "CLASSE")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findById", query = "SELECT c FROM Classe c WHERE c.id = :id"),
    @NamedQuery(name = "Classe.findByNom", query = "SELECT c FROM Classe c WHERE c.nom = :nom")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private Collection<Etudiant> etudiantCollection;
    @JoinColumn(name = "id_filiere", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departement idFiliere;
    @JoinColumn(name = "id_niveau", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departement idNiveau;
    @JoinColumn(name = "id_formation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departement idFormation;

    public Classe() {
    }

    public Classe(Integer id) {
        this.id = id;
    }

    public Classe(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
    }

    public Departement getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Departement idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Departement getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Departement idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Departement getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Departement idFormation) {
        this.idFormation = idFormation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.iutgi.iutVote.entities.Classe[ id=" + id + " ]";
    }
    
}
