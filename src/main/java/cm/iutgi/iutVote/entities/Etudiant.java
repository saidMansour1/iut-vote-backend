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
@Table(name = "ETUDIANT")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findEtudiant", query = "SELECT e FROM Etudiant e WHERE e.matricule = :id AND e.motDePasse = :mdp"),
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findById", query = "SELECT e FROM Etudiant e WHERE e.id = :id"),
    @NamedQuery(name = "Etudiant.findByMatricule", query = "SELECT e FROM Etudiant e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiant.findByPseudo", query = "SELECT e FROM Etudiant e WHERE e.pseudo = :pseudo"),
    @NamedQuery(name = "Etudiant.findByMotDePasse", query = "SELECT e FROM Etudiant e WHERE e.motDePasse = :motDePasse"),
    @NamedQuery(name = "Etudiant.findByNumeroTel", query = "SELECT e FROM Etudiant e WHERE e.numeroTel = :numeroTel"),
    @NamedQuery(name = "Etudiant.findByMail", query = "SELECT e FROM Etudiant e WHERE e.mail = :mail")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;
    @Size(max = 30)
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
    @JoinColumn(name = "id_classe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classe idClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtudiant")
    private Collection<Candidat> candidatCollection;

    public Etudiant() {
    }

    public Etudiant(Integer id) {
        this.id = id;
    }

    public Etudiant(Integer id, String matricule, String nom, String motDePasse) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public Collection<Candidat> getCandidatCollection() {
        return candidatCollection;
    }

    public void setCandidatCollection(Collection<Candidat> candidatCollection) {
        this.candidatCollection = candidatCollection;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.iutgi.iutVote.entities.Etudiant[ id=" + id + " ]";
    }
    
}
