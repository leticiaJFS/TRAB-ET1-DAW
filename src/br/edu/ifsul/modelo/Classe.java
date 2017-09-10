package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="classe")
public class Classe implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_classe", sequenceName = "seq_classe_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_classe",strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotNull(message="O nome não pode ser nulo")
    @NotBlank(message="O nome não pode ser em branco")
    @Length(max = 20, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name="nome", length=40, nullable = false)
    private String nome;
    @Column(name="valor", columnDefinition = "numeric(12,2)")
    private Double valor;

    public Classe() {
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Classe other = (Classe) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
