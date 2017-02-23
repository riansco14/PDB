package model;

import javax.persistence.*;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Aeronave {
    private Tripulacao tripulacao;

    @OneToOne(cascade = CascadeType.ALL)
    public Tripulacao getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(Tripulacao tripulacao) {
        this.tripulacao = tripulacao;
    }

    private int numAssentos;

    @Basic
    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }

    private int id;

    @GeneratedValue@Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nome;

    @Basic
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private Empresa companhia;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    public Empresa getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Empresa companhia) {
        this.companhia = companhia;
    }

    public void build(Tripulacao tripulacao, int numAssentos,  String nome, Empresa companhia) {
        this.tripulacao = tripulacao;
        this.numAssentos = numAssentos;
        this.nome = nome;
        this.companhia = companhia;
    }
}
