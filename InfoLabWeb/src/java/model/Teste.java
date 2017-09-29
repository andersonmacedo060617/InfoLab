/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "teste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teste.findAll", query = "SELECT t FROM Teste t")
    , @NamedQuery(name = "Teste.findByIdteste", query = "SELECT t FROM Teste t WHERE t.idteste = :idteste")
    , @NamedQuery(name = "Teste.findByTeste", query = "SELECT t FROM Teste t WHERE t.teste = :teste")})
public class Teste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idteste")
    private Integer idteste;
    @Column(name = "teste")
    @Temporal(TemporalType.TIMESTAMP)
    private Date teste;

    public Teste() {
    }

    public Teste(Integer idteste) {
        this.idteste = idteste;
    }

    public Integer getIdteste() {
        return idteste;
    }

    public void setIdteste(Integer idteste) {
        this.idteste = idteste;
    }

    public Date getTeste() {
        return teste;
    }

    public void setTeste(Date teste) {
        this.teste = teste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteste != null ? idteste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teste)) {
            return false;
        }
        Teste other = (Teste) object;
        if ((this.idteste == null && other.idteste != null) || (this.idteste != null && !this.idteste.equals(other.idteste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Teste[ idteste=" + idteste + " ]";
    }
    
}
