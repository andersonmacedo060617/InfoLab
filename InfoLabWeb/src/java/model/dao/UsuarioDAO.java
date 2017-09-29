/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author aluno
 */
public class UsuarioDAO extends BaseDAO{
    
    public Usuario login(String login, String senha){
        this.open();
        
        try{
            Query q = em.createQuery("select u from Usuario u where "
                + " u.login = :login and u.senha = :senha");
        
            q.setParameter("login", login);
            q.setParameter("senha", senha);

            return (Usuario) q.getSingleResult();
        
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            return null;
        }finally{
            this.close();
        }
    }
    
    public List<Usuario> findUsuarioLoginCpf(String login, String cpf){
        this.open();
        
        try{
            Query q = em.createNamedQuery("Usuario.findUsuarioByLoginOrCPF");
            q.setParameter("login", login);
            q.setParameter("cpf", cpf);
            return q.getResultList();
        }finally{
            this.close();
        }
    }

    public List<Usuario> findAllClientes() {
        this.open();
        
        try{
            Query q = em.createNamedQuery("Usuario.findAllClientes");
            return q.getResultList();
        }finally{
            this.close();
        }
    }
    
    public Usuario findClienteById(int Id) {
        this.open();
        
        try{
            Query q = em.createNamedQuery("Usuario.findClienteById");
            q.setParameter("id", Id);
            return (Usuario) q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            return null;
        }finally{
            this.close();
        }
    }
    
    
    
    public List<Usuario> findAllFuncionarios() {
        this.open();
        
        try{
            Query q = em.createNamedQuery("Usuario.findAllFuncionarios");
            return q.getResultList();
        }finally{
            this.close();
        }
    }
    
    public Usuario findFuncionarioById(int Id) {
        this.open();
        
        try{
            Query q = em.createNamedQuery("Usuario.findFuncionarioById");
            q.setParameter("id", Id);
            return (Usuario) q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            return null;
        }finally{
            this.close();
        }
    }
    
    public void SaveUsuario(Usuario usuario){
        this.open();
        try{
            em.getTransaction().begin();
            
            em.persist(usuario);
            em.getTransaction().commit();
        }catch(Exception ex){
            throw ex;
        }finally{
            close();
        }
        
    }
    
}

