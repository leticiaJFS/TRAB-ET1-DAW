package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Leticia-PC
 */
@Entity
@Table(name="passagem")
public class Passagem implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_passagem", sequenceName = "seq_passagem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_passagem",strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name="data_compra")
    private Calendar dataCompra;
    @Column(name="bagagem", nullable = false)
    private Integer bagagem;
    @NotNull(message="A pessoa não pode ser nula")
    @ManyToOne
    @JoinColumn(name="pessoa", referencedColumnName= "id", nullable = false)
    @ForeignKey(name="fk_pessoa_id")
    private Pessoa p;
    @NotNull(message="A classe não pode ser nula")
    @ManyToOne
    @JoinColumn(name="classe", referencedColumnName= "id", nullable = false)
    @ForeignKey(name="fk_classe_id")
    private Classe C;
    @NotNull(message="O voo agendado não pode ser nulo")
    @ManyToOne
    @JoinColumn(name="voo_agendado", referencedColumnName= "id", nullable = false)
    @ForeignKey(name="fk_voo_agendado_id")
    private VooAgendado va;

    public Passagem() {
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getBagagem() {
        return bagagem;
    }

    public void setBagagem(Integer bagagem) {
        this.bagagem = bagagem;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public Classe getC() {
        return C;
    }

    public void setC(Classe C) {
        this.C = C;
    }   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VooAgendado getVa() {
        return va;
    }

    public void setVa(VooAgendado va) {
        this.va = va;
    }
    
    
}
