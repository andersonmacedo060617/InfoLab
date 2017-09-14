/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public abstract class BaseDAO {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    
    protected void open(){
        emf = Persistence.createEntityManagerFactory("InfoLabWebPU");
        em = emf.createEntityManager();
    }
    
    protected void close(){
        em.close();
        emf.close();
    }
}
