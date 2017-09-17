package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.VooAgendado;
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
public class TestePesistirVooAgendado {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePesistirVooAgendado() {  
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
            Voo v = em.find(Voo.class, 1);
            VooAgendado va = new VooAgendado();
            va.setAeronave("aeronave 2");
            va.setData(new GregorianCalendar(2017, Calendar.SEPTEMBER, 18));
            va.setTotalPassageiros(15);
            va.setV(v);
            
            em.getTransaction().begin();
            em.persist(va);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(); // imprime todos os erros no console
            exception = true;
        }
        //verifica se o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }
    
}
