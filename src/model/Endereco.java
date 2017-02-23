package model;

import model.City.Cidade;

import javax.persistence.*;


/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Endereco {

    public Endereco build(String rua, String pais, String estado, String cidade, String bairro, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        return this;
    }

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String rua;

    @Basic
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    private String bairro;

    @Basic
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    private int numero;

    @Basic
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private Cidade cidade;

    @OneToOne(optional = false)
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
