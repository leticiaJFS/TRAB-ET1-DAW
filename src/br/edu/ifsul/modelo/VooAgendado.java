package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leticia-PC
 */
@Entity
@Table(name="voo_agendado")
public class VooAgendado implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_voo_agendado", sequenceName = "seq_voo_agendado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_voo_agendado",strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotNull(message="A aeronave não pode ser nula")
    @NotBlank(message="A aeronave não pode ser em branco")
    @Column(name="aeronave", nullable = false, length = 20)
    @Length(max = 20, message = "A aeronave não pode ter mais que {max} caracteres")
    private String aeronave;
    @Column(name="total_passageiros", nullable = false)
    private Integer totalPassageiros;
    @Temporal(TemporalType.DATE)
    @Column(name="data")
    private Calendar data;
    @NotNull(message="O voo não pode ser nulo")
    @ManyToOne
    @JoinColumn(name="voo", referencedColumnName= "id", nullable = false)
    @ForeignKey(name="fk_voo_id") // 
    private Voo v;
    @OneToMany(mappedBy = "va", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Passagem> passagens = new ArrayList<>();

    public VooAgendado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public Integer getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(Integer totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VooAgendado other = (VooAgendado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void adicionarPassagem(Passagem obj){
        obj.setVa(this);
        this.passagens.add(obj);
    }
    
    public void removerPassagem(int index){
        Passagem obj = this.passagens.get(index);
        this.passagens.remove(index);
    }

    public Voo getV() {
        return v;
    }

    public void setV(Voo v) {
        this.v = v;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
    
    
}
