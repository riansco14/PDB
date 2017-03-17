package model;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

/**
 * Created by RIAN on 04/02/2017.
 */
@Entity
public class Produto_Voo {
    private double valorEconomico;

    @Basic
    public double getValorEconomico() {
        return valorEconomico;
    }

    public void setValorEconomico(double valorEconomico) {
        this.valorEconomico = valorEconomico;
    }

    private double valorExecutivo;

    @Basic
    public double getValorExecutivo() {
        return valorExecutivo;
    }

    public void setValorExecutivo(double valorExecutivo) {
        this.valorExecutivo = valorExecutivo;
    }

    private Date dataPartida;

    private List<Voo> trechos;

    @OneToMany
    public List<Voo> getTrechos() {
        return trechos;
    }

    public void setTrechos(List<Voo> trechos) {
        this.trechos = trechos;
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

    private Aeroporto origem;

    @OneToOne
    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    private Aeroporto destino;

    @OneToOne
    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }
}
