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

    //    @OneToMany
//    public Collection<Assento> getAssentos() {
//        return assentos;
//    }
//
//    public void setAssentos(Collection<Assento> assentos) {
//        this.assentos = assentos;
//    }

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

    @OneToOne(optional = false)
    public Empresa getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Empresa companhia) {
        this.companhia = companhia;
    }
}
