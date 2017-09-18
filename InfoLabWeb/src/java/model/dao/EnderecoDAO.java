/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.Endereco;
import model.Usuario;

/**
 *
 * @author Anderson2
 */
public class EnderecoDAO extends BaseDAO{
    
    public void SaveEndereco(Endereco endereco){
        this.open();
        try{
            em.getTransaction().begin();
            
            em.persist(endereco);
            em.getTransaction().commit();
        }catch(Exception ex){
            throw ex;
        }finally{
            close();
        }
        
    }
}
