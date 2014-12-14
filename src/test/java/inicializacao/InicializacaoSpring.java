/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inicializacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Component
public class InicializacaoSpring {

    static public ApplicationContext ctx;

            

    @BeforeClass
    public static void setUpClass() {


        System.out.println("Iniciando contexto Spring");

        long tempoInicial = System.currentTimeMillis();

        try {
            ctx = new FileSystemXmlApplicationContext("/src/test/java/applicationContextTeste.xml");

            System.out.println("Contexto Spring iniciado com sucesso em " +
                    getTempoTotal(tempoInicial) + " milisegundos");

        } catch (Throwable t) {
            System.out.println("Contexto Spring não pôde ser iniciado: "+t.getMessage());
            t.printStackTrace();
        }
    }

    private static long getTempoTotal(Long tempoInicial) {
        return System.currentTimeMillis() - tempoInicial;
    }

    @Test(groups="SPRING")
    public void testeDeAcessoAoBanco() {
       EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
        EntityManager em = emf.createEntityManager();

        Assert.assertNotNull(em);
        
    }

}