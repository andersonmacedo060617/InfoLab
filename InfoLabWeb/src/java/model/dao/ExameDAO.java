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
import model.Usuario;

/**
 *
 * @author aluno
 */
public class ExameDAO extends BaseDAO{
    
    public List<Exame> findAllExames() {
        this.open();
        
        try{
            Query q = em.createNamedQuery("Exame.findAllExames");
            return q.getResultList();
        }finally{
            this.close();
        }
    }
    
    public void SaveExame(Exame exame){
        this.open();
        try{
            em.getTransaction().begin();
            
            em.persist(exame);
            em.getTransaction().commit();
        }catch(Exception ex){
            throw ex;
        }finally{
            close();
        }
    }
    
    public Exame findExameById(int IdExame){
        this.open();
        
        try{
            Query q = em.createNamedQuery("Exame.findExameById");
        
            q.setParameter("id", IdExame);

            return (Exame) q.getSingleResult();
        
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            return null;
        }finally{
            this.close();
        }
    }
    
    public void deleteExame(Exame exame){
        this.open();
        try{
            
            Exame ex = em.merge(exame);
            em.getTransaction().begin();
            em.remove(ex);
            em.getTransaction().commit();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.close();
        }
    }
}
