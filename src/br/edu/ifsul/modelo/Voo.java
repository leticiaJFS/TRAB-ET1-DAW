package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leticia-PC
 */
@Entity
@Table(name="voo")
public class Voo implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_voo", sequenceName = "seq_voo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_voo",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message="A descrição não pode ser nula")
    @NotBlank(message="A descrição não pode ser em branco")
    @Column(name="descricao", nullable = false, columnDefinition = "text")
    private String descricao;
    @NotNull(message="O tempo estimado não pode ser nulo")
    @Column(name="tempo_estimado", nullable = false, columnDefinition = "numeric(10,2)")
    private Double tempoEstimado;
    @NotNull(message="O campo ativo não pode ser nulo")
    @Column(name="ativo", length=1, nullable = false)
    private Boolean ativo;
    @NotNull(message="A periodicidade não pode ser nula")
    @NotBlank(message="A periodicidade não pode ser em branco")
    @Column(name="periodicidade", nullable = false, length = 30)
    @Length(max = 30, message = "A periodicidade não pode ter mais que {max} caracteres")
    private String periodicidade;
    @ManyToMany
    @JoinTable(name="escalas", joinColumns = @JoinColumn(name = "voo", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="aeroporto", referencedColumnName = "id", nullable = false ))
    private List<Aeroporto> escalas = new ArrayList<>();
    @OneToMany(mappedBy = "v", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VooAgendado> voos_agendados = new ArrayList<>();

    public Voo() {
    }

    public void adicionarVooAgendado(VooAgendado obj){
        obj.setV(this);
        this.voos_agendados.add(obj);
    }
    
    public void removerVooAgendado(int index){
        VooAgendado obj = this.voos_agendados.get(index);
        this.voos_agendados.remove(index);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public List<Aeroporto> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Aeroporto> escalas) {
        this.escalas = escalas;
    }

    public List<VooAgendado> getVoos_agendados() {
        return voos_agendados;
    }

    public void setVoos_agendados(List<VooAgendado> voos_agendados) {
        this.voos_agendados = voos_agendados;
    }
    
    
}
