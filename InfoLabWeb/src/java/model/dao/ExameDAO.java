/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
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
}
