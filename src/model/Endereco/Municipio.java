package model.Endereco;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by RIAN on 21/02/2017.
 */

@Entity
public class Municipio implements Serializable {

    @Id
    private Long id;
    private String nome;
    private int cepInicial;
    private int cepFinal;
    @ManyToOne
    private Estado estado;

    public Municipio() {
        estado = new Estado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCepInicial() {
        return cepInicial;
    }

    public void setCepInicial(int cepInicial) {
        this.cepInicial = cepInicial;
    }

    public int getCepFinal() {
        return cepFinal;
    }

    public void setCepFinal(int cepFinal) {
        this.cepFinal = cepFinal;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Municipio) {
            Municipio outro = (Municipio) obj;
            if (outro.getId().equals(this.id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getNome() + (estado == null ? "" : " - " + estado.getUf());
    }

}
