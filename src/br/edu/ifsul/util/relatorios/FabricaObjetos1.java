/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leticia-PC
 */
public class FabricaObjetos1 {
   
    public static List<Voo> carregaVoos(){
        List<Voo> lista = new ArrayList<>();
        
        VooAgendado va = new VooAgendado();
        va.setId(1);
        va.setAeronave("aeronave 1");
        va.setTotalPassageiros(12);
        va.setData(null);
        
        Voo v1 = new Voo();
        v1.setId(1);
        v1.setDescricao("voo 1");
        v1.setAtivo(true);
        v1.setPeriodicidade("sei la");
        v1.adicionarVooAgendado(va);
        v1.setTempoEstimado(12.0);
        lista.add(v1);
        
        Voo v2 = new Voo();
        v2.setId(2);
        v2.setDescricao("voo 1");
        v2.setAtivo(true);
        v2.setPeriodicidade("sei la");
        v2.adicionarVooAgendado(va);
        v2.setTempoEstimado(10.0);        
        lista.add(v2);
        
        return lista;
    }
    
}
