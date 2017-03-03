package model.Endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * Created by RIAN on 10/11/2016.
 */

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    @ManyToOne
    private Municipio municipio;

    public Endereco() {
        this.municipio = new Municipio();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Endereco) {
            Endereco outro = (Endereco) obj;
            if (outro.getId().equals(this.id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return logradouro + ", " + numero + " - " + bairro + " - " + municipio.getNome() + " - " + municipio.getEstado();
    }

}
