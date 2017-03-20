package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Basic
    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    private List<Voo> trechos;

    @ManyToMany
    @JoinTable(name="produto_voo_trechos", joinColumns=
            {@JoinColumn(name="produto_voo_id")}, inverseJoinColumns=
            {@JoinColumn(name="voos_id")})
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

    private Boolean vooComEscala;

    @Basic
    public Boolean getVooComEscala() {
        return vooComEscala;
    }

    public void setVooComEscala(Boolean basic) {
        this.vooComEscala = basic;
    }

    private Date dataChegada;

    @Basic
    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }
}
