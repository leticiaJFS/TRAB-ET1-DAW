package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirClasse {
    
        EntityManagerFactory emf;
        EntityManager em;
    
    public TestePersistirClasse() {
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
            Classe C = new Classe();
            C.setNome("A");
            C.setValor(800.00);
            em.getTransaction().begin();
            em.persist(C);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(); // imprime todos os erros no console
            exception = true;
        }
        //verifica se o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }
    
}
