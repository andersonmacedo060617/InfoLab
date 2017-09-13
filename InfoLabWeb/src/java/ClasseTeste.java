
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class ClasseTeste {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoLabWebPU");
        
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("select u from Usuario u where u.id = 1");

        try{
            Usuario u1 = (Usuario)q.getSingleResult();
            System.out.println("==>" + u1.getNome());
        
        }catch(NoResultException e){
            System.out.println("Nenhum Usuario Encontrado");
        }catch(NonUniqueResultException e){
            System.out.println("Mais de um usuario encontrado");
            List<Usuario> listaU = q.getResultList();
            System.out.println("==>" + listaU.size());
        
        }
    }
}
