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
import javax.persistence.Lob;
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
@Table(name = "DEPARTEMENT")
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findById", query = "SELECT d FROM Departement d WHERE d.id = :id"),
    @NamedQuery(name = "Departement.findByNom", query = "SELECT d FROM Departement d WHERE d.nom = :nom")})
public class Departement implements Serializable {

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
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFiliere")
    private Collection<Classe> classeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNiveau")
    private Collection<Classe> classeCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormation")
    private Collection<Classe> classeCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDep")
    private Collection<Filiere> filiereCollection;

    public Departement() {
    }

    public Departement(Integer id) {
        this.id = id;
    }

    public Departement(Integer id, String nom) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Collection<Classe> getClasseCollection() {
        return classeCollection;
    }

    public void setClasseCollection(Collection<Classe> classeCollection) {
        this.classeCollection = classeCollection;
    }

    public Collection<Classe> getClasseCollection1() {
        return classeCollection1;
    }

    public void setClasseCollection1(Collection<Classe> classeCollection1) {
        this.classeCollection1 = classeCollection1;
    }

    public Collection<Classe> getClasseCollection2() {
        return classeCollection2;
    }

    public void setClasseCollection2(Collection<Classe> classeCollection2) {
        this.classeCollection2 = classeCollection2;
    }

    public Collection<Filiere> getFiliereCollection() {
        return filiereCollection;
    }

    public void setFiliereCollection(Collection<Filiere> filiereCollection) {
        this.filiereCollection = filiereCollection;
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
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.iutgi.iutVote.entities.Departement[ id=" + id + " ]";
    }
    
}
