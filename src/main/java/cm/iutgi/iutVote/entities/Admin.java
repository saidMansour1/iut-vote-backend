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
@Table(name = "ADMIN")
@NamedQueries({    
    @NamedQuery(name = "Admin.findAdmin", query = "SELECT a FROM Admin a WHERE a.mail = :id AND a.motDePasse = :mdp"),
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findById", query = "SELECT a FROM Admin a WHERE a.id = :id"),
    @NamedQuery(name = "Admin.findByNom", query = "SELECT a FROM Admin a WHERE a.nom = :nom"),
    @NamedQuery(name = "Admin.findByPseudo", query = "SELECT a FROM Admin a WHERE a.pseudo = :pseudo"),
    @NamedQuery(name = "Admin.findByMotDePasse", query = "SELECT a FROM Admin a WHERE a.motDePasse = :motDePasse"),
    @NamedQuery(name = "Admin.findByNumeroTel", query = "SELECT a FROM Admin a WHERE a.numeroTel = :numeroTel"),
    @NamedQuery(name = "Admin.findByMail", query = "SELECT a FROM Admin a WHERE a.mail = :mail")})
public class Admin implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pseudo")
    private String pseudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Size(max = 9)
    @Column(name = "numero_tel")
    private String numeroTel;
    @Size(max = 60)
    @Column(name = "mail")
    private String mail;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdmin")
    private Collection<Election> electionCollection;

    public Admin() {
    }

    public Admin(Integer id) {
        this.id = id;
    }

    public Admin(Integer id, String nom, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.motDePasse = motDePasse;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Collection<Election> getElectionCollection() {
        return electionCollection;
    }

    public void setElectionCollection(Collection<Election> electionCollection) {
        this.electionCollection = electionCollection;
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
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.iutgi.iutVote.entities.Admin[ id=" + id + " ]";
    }
    
}
