package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Voo;
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
public class TestePersistirVoo {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirVoo() {
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
            Voo v = new Voo();
            v.setDescricao("voo de curta distância");
            v.setTempoEstimado(15.00);
            v.setAtivo(true);
            v.setPeriodicidade("sei la");
            
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(); // imprime todos os erros no console
            exception = true;
        }
        //verifica se o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }
    
}
