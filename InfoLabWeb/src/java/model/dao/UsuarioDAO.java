/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

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
    
}

