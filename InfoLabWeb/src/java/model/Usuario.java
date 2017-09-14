/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author aluno
 */
@Entity
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nome;

    @Basic(optional = false)
    @Column(nullable = true, length = 45)
    private String cpf;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 45, unique = true)
    private String login;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String senha;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean cliente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Telefone> telefones;
    
    @JoinColumn(name = "ENDERECO_ID", referencedColumnName = "ID", nullable = false)
    @OneToOne(optional = false)
    private Endereco endereco;
    
    @OneToMany(mappedBy = "idusuario")
    private List<ExamesUsuario> examesUsuario;
    
    
    public Usuario() {
        this.telefones = new ArrayList<>();
        this.examesUsuario = new ArrayList<>();
    }
    
    
    public Usuario(String nome, String login, String senha, boolean isCliente) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cliente = isCliente;
        this.telefones = new ArrayList<>();
        this.examesUsuario = new ArrayList<>();
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ExamesUsuario> getExamesUsuario() {
        return examesUsuario;
    }

    public void setExamesUsuario(List<ExamesUsuario> examesUsuario) {
        this.examesUsuario = examesUsuario;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
