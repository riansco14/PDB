package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Voo {

    public void Construtor(Rota rota, Collection<Voo> trechos, Aeronave aeronave, boolean estado, Date dataChegada, Date dataPartida, double valorEconomico, double valorExecutivo, int vagasEconomico, int vagasExecutivo, int vagasTotal) {
        this.rota = rota;
        this.aeronave = aeronave;
        this.estado = estado;
        this.dataChegada = dataChegada;
        this.dataPartida = dataPartida;
    }

    private Rota rota;

    @OneToOne//(optional = false)
    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    private Aeronave aeronave;

    @OneToOne//(optional = false)
    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    private int id;

    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private boolean estado;

    @Basic
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    private Date dataChegada;

    @Basic
    @Temporal(TIMESTAMP)
    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    private Date dataPartida;

    @Basic
    @Temporal(TIMESTAMP)
    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    private Collection<Assento> assentos;

    @OneToMany
    public Collection<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(Collection<Assento> assentos) {
        this.assentos = assentos;
    }
}
