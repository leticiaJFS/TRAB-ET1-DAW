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
@Table(name="cidade")
public class Cidade implements Serializable { 
    @Id
    @SequenceGenerator(name="seq_cidade", sequenceName = "seq_cidade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade",strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotNull(message="O nome não pode ser nulo")
    @NotBlank(message="O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name="nome", length=40, nullable = false)
    private String nome;
    @NotNull(message="O país não pode ser nulo")
    @NotBlank(message="O país não pode ser em branco")
    @Length(max = 30, message = "O país não pode ter mais que {max} caracteres")
    @Column(name="pais", length=30, nullable = false)
    private String pais;
    
    
    public Cidade() {
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
