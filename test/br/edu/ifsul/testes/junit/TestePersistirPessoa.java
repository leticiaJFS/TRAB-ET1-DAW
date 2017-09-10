package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Pessoa;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leticia-PC
 */
public class TestePersistirPessoa {
       
        EntityManagerFactory emf;
        EntityManager em;
        
    public TestePersistirPessoa() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-5N1-AEROPORTO-PU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        
        try{ 
            Pessoa P = new Pessoa();            
            P.setNome("Letícia");
            P.setCpf("03319394010");
            P.setEmail("le-tyfagundes@hotmail.com");
            P.setTelefone("(54)98435-7876");
            
            em.getTransaction().begin();
            em.persist(P);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(); // imprime todos os erros no console
            exception = true;
        }
        //verifica se o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }
    
}
