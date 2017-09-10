package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Leticia-PC
 */
@Entity
@Table(name="aeroporto")
public class Aeroporto implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_aeroporto", sequenceName = "seq_aeroporto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aeroporto",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message="O nome não pode ser nulo")
    @NotBlank(message="O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name="nome", length=40, nullable = false)
    private String nome;
    @NotNull(message="A operação não pode ser nula")
    @Column(name="operacaoNoturna", length=1, nullable = false)
    private Boolean operacaoNoturna;
    @NotNull(message="A cidade não pode ser nulo")
    @ManyToOne
    @JoinColumn(name="cidade", referencedColumnName= "id", nullable = false)
    @ForeignKey(name="fk_cidade_id")
    private Cidade cidade;
    @ManyToMany
    @JoinTable(name="escalas", joinColumns = @JoinColumn(name = "aeroporto", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="voo", referencedColumnName = "id", nullable = false ))    
    private List<Voo> escalam = new ArrayList<Voo>();
    
    
    public Aeroporto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getOperacaoNoturna() {
        return operacaoNoturna;
    }

    public void setOperacaoNoturna(Boolean operacaoNoturna) {
        this.operacaoNoturna = operacaoNoturna;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Aeroporto other = (Aeroporto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
}
