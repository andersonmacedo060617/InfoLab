/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author aluno
 */
@Entity
public class ExamesUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    private Date dataExame;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private Date dataEntregaPrevista;
    
    @Basic(optional = true)
    @Column(nullable = true)
    private Date dataEntregaConcluida;
    
    @Basic(optional = true)
    @Column(nullable = true)
    private Date dataExamePronto;
    
    @Basic(optional = true)
    @Column(nullable = true)
    private double valor;
    
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idusuario;
    
    @JoinColumn(name = "EXAME_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Exame idexame;

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Date getDataEntregaPrevista() {
        return dataEntregaPrevista;
    }

    public void setDataEntregaPrevista(Date dataEntregaPrevista) {
        this.dataEntregaPrevista = dataEntregaPrevista;
    }

    public Date getDataEntregaConcluida() {
        return dataEntregaConcluida;
    }

    public void setDataEntregaConcluida(Date dataEntregaConcluida) {
        this.dataEntregaConcluida = dataEntregaConcluida;
    }

    public Date getDataExamePronto() {
        return dataExamePronto;
    }

    public void setDataExamePronto(Date dataExamePronto) {
        this.dataExamePronto = dataExamePronto;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Exame getIdexame() {
        return idexame;
    }

    public void setIdexame(Exame idexame) {
        this.idexame = idexame;
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
        if (!(object instanceof ExamesUsuario)) {
            return false;
        }
        ExamesUsuario other = (ExamesUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ExamesUsuario[ id=" + id + " ]";
    }
    
}
