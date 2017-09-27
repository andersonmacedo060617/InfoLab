/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author aluno
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Exame.findAllExames", query = "SELECT e FROM Exame e"),
    @NamedQuery(name = "Exame.findExameById", query = "SELECT e FROM Exame e WHERE e.id = :id"),
})
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nomeExame;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private double valor;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private int horasEntrega;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private int horasJejum;    
        
    @OneToMany(mappedBy = "idexame")
    private List<ExamesUsuario> examesUsuario;
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exame() {
    }

    public Exame(String nomeExame, double valor, int horasEntrega, int horasJejum) {
        this.nomeExame = nomeExame;
        this.valor = valor;
        this.horasEntrega = horasEntrega;
        this.horasJejum = horasJejum;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getHorasEntrega() {
        return horasEntrega;
    }

    public void setHorasEntrega(int horasEntrega) {
        this.horasEntrega = horasEntrega;
    }

    public int getHorasJejum() {
        return horasJejum;
    }

    public void setHorasJejum(int horasJejum) {
        this.horasJejum = horasJejum;
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
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exame[ id=" + id + " ]";
    }
    
}
