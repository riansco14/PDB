package model;

import javax.persistence.*;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Aeronave {
    private Tripulacao tripulacao;

    public Aeronave build(Tripulacao tripulacao, int numAssentosTotal, int id, String nome, Empresa companhia,
			int numAssentosEco, int numAssentosExe) {
		this.tripulacao = tripulacao;
		this.numAssentosTotal = numAssentosTotal;
		this.id = id;
		this.nome = nome;
		this.companhia = companhia;
		this.numAssentosEco = numAssentosEco;
		this.numAssentosExe = numAssentosExe;
		return this;
	}

	@OneToOne
    public Tripulacao getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(Tripulacao tripulacao) {
        this.tripulacao = tripulacao;
    }

    private int numAssentosTotal;

    @Basic
    public int getNumAssentosTotal() {
        return numAssentosTotal;
    }

    public void setNumAssentosTotal(int numAssentos) {
        this.numAssentosTotal = numAssentos;
    }

    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    public void build(Tripulacao tripulacao, int numAssentos,  String nome, Empresa companhia) {
        this.tripulacao = tripulacao;
        this.numAssentosTotal = numAssentos;
        this.nome = nome;
        this.companhia = companhia;
    }

    private int numAssentosEco;

    @Basic
    public int getNumAssentosEco() {
        return numAssentosEco;
    }

    public void setNumAssentosEco(int numAssentosEconomico) {
        this.numAssentosEco = numAssentosEconomico;
    }

    private int numAssentosExe;

    @Basic
    public int getNumAssentosExe() {
        return numAssentosExe;
    }

    public void setNumAssentosExe(int numAssentosExe) {
        this.numAssentosExe = numAssentosExe;
    }
}
