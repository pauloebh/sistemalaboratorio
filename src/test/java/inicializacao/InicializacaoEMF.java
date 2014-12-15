/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inicializacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Component
public class InicializacaoEMF {

     public static EntityManagerFactory emf;

    public InicializacaoEMF() {
    }

    @BeforeClass
    public static void setUpClass() {

        emf = Persistence.createEntityManagerFactory("bqPersistence");
        
    }

    @Test
    public void testeDeAcessoAoBanco() throws Exception {
        EntityManager em = emf.createEntityManager();
        
        String nome = ""+ em
                .createNativeQuery("select 1")
                .getSingleResult();

        if (nome == null) throw new Exception();
        
    }

}