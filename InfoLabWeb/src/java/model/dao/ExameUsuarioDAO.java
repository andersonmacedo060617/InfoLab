/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import model.Exame;
import model.ExamesUsuario;
import model.Usuario;

/**
 *
 * @author Anderson2
 */
public class ExameUsuarioDAO extends BaseDAO{
    
    public List<ExamesUsuario> findAllExamesUsuario() {
        this.open();
        
        try{
            Query q = em.createNamedQuery("ExameUsuario.findAllExamesUsuario");
            return q.getResultList();
        }finally{
            this.close();
        }
    }
    
    public List<ExamesUsuario> findAllExamesUsuarioByIdUsuario(int IdUsuario) {
        this.open();
        
        try{
            Query q = em.createNamedQuery("ExameUsuario.findAllExamesUsuarioByIdUsuario");
            q.setParameter("id", IdUsuario);
            return q.getResultList();
        }finally{
            this.close();
        }
    }
    
    public void SaveExame(ExamesUsuario exameUsuario){
        this.open();
        try{
            em.getTransaction().begin();
            
            em.persist(exameUsuario);
            em.getTransaction().commit();
        }catch(Exception ex){
            throw ex;
        }finally{
            close();
        }
    }
    
    public ExamesUsuario findExameClienteById(int Id) {
        this.open();
        
        try{
            Query q = em.createNamedQuery("ExameUsuario.findExamesUsuarioById");
            q.setParameter("id", Id);
            return (ExamesUsuario) q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            return null;
        }finally{
            this.close();
        }
        
    }
    
    public void UpdateExameUsuario(ExamesUsuario exameCliente){
        this.open();
        try{
            em.getTransaction().begin();
            
            em.merge(exameCliente);
            em.getTransaction().commit();
        }catch(Exception ex){
            throw ex;
        }finally{
            close();
        }
    }
    
}
