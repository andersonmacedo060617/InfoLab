/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.Query;
import model.Exame;
import model.ExamesUsuario;

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
}
