/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cm.iutgi.iutVote.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author saims
 */
@Entity
@Table(name = "ELECTION")
@NamedQueries({
    @NamedQuery(name = "Election.findAll", query = "SELECT e FROM Election e"),
    @NamedQuery(name = "Election.findById", query = "SELECT e FROM Election e WHERE e.id = :id"),
    @NamedQuery(name = "Election.findByNom", query = "SELECT e FROM Election e WHERE e.nom = :nom"),
    @NamedQuery(name = "Election.findByDateDebut", query = "SELECT e FROM Election e WHERE e.dateDebut = :dateDebut"),
    @NamedQuery(name = "Election.findByDateFin", query = "SELECT e FROM Election e WHERE e.dateFin = :dateFin"),
    @NamedQuery(name = "Election.findByIdClasse", query = "SELECT e FROM Election e WHERE e.idClasse = :idClasse"),
    @NamedQuery(name = "Election.findByIdDepartement", query = "SELECT e FROM Election e WHERE e.idDepartement = :idDepartement"),
    @NamedQuery(name = "Election.findByIdNiveau", query = "SELECT e FROM Election e WHERE e.idNiveau = :idNiveau"),
    @NamedQuery(name = "Election.findByIdFiliere", query = "SELECT e FROM Election e WHERE e.idFiliere = :idFiliere"),
    @NamedQuery(name = "Election.findByIdFormation", query = "SELECT e FROM Election e WHERE e.idFormation = :idFormation")})
public class Election implements Serializable {

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
    @Column(name = "date_debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "id_classe")
    private Integer idClasse;
    @Column(name = "id_departement")
    private Integer idDepartement;
    @Column(name = "id_niveau")
    private Integer idNiveau;
    @Column(name = "id_filiere")
    private Integer idFiliere;
    @Column(name = "id_formation")
    private Integer idFormation;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "idElection")
    private Collection<EectionCandidat> eectionCandidatCollection;
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Admin idAdmin;

    public Election() {
    }

    public Election(Integer id) {
        this.id = id;
    }

    public Election(Integer id, String nom, Date dateDebut, Date dateFin) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Integer getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Integer getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Integer getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<EectionCandidat> getEectionCandidatCollection() {
        return eectionCandidatCollection;
    }

    public void setEectionCandidatCollection(Collection<EectionCandidat> eectionCandidatCollection) {
        this.eectionCandidatCollection = eectionCandidatCollection;
    }

    public Admin getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Admin idAdmin) {
        this.idAdmin = idAdmin;
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
        if (!(object instanceof Election)) {
            return false;
        }
        Election other = (Election) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.iutgi.iutVote.entities.Election[ id=" + id + " ]";
    }
    
}
