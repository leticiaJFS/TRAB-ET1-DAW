package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Passagem;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirPassagem {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPassagem() {
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
            Passagem p = new Passagem();
            Classe c = em.find(Classe.class, 1);
            VooAgendado va = em.find(VooAgendado.class, 1);
            Pessoa pe = em.find(Pessoa.class, 1);
            p.setBagagem(3);
            p.setC(c);
            p.setP(pe);
            p.setVa(va);
            p.setDataCompra(new GregorianCalendar(2017, Calendar.SEPTEMBER, 18));
     
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(); // imprime todos os erros no console
            exception = true;
        }
        //verifica se o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }
    
    
}
