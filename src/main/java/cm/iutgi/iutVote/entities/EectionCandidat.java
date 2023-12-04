/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cm.iutgi.iutVote.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author saims
 */
@Entity
@Table(name = "EECTION_CANDIDAT")
@NamedQueries({
    @NamedQuery(name = "EectionCandidat.findAll", query = "SELECT e FROM EectionCandidat e"),
    @NamedQuery(name = "EectionCandidat.findById", query = "SELECT e FROM EectionCandidat e WHERE e.id = :id")})
public class EectionCandidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "idElectionCandidat")
    private Collection<Vote> voteCollection;
    @JoinColumn(name = "id_candidat", referencedColumnName = "id")
    @ManyToOne
    private Candidat idCandidat;
    @JoinColumn(name = "id_election", referencedColumnName = "id")
    @ManyToOne
    private Election idElection;

    public EectionCandidat() {
    }

    public EectionCandidat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    public Candidat getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Candidat idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Election getIdElection() {
        return idElection;
    }

    public void setIdElection(Election idElection) {
        this.idElection = idElection;
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
        if (!(object instanceof EectionCandidat)) {
            return false;
        }
        EectionCandidat other = (EectionCandidat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.iutgi.iutVote.entities.EectionCandidat[ id=" + id + " ]";
    }
    
}
