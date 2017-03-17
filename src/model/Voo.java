package model;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Voo {

    public void Construtor( List<Voo> trechos, Aeronave aeronave, boolean estado, Date dataChegada, Date dataPartida, double valorEconomico, double valorExecutivo, int vagasEconomico, int vagasExecutivo, int vagasTotal) {
        this.aeronave = aeronave;
        this.estado = estado;
        this.dataChegada = dataChegada;
        this.dataPartida = dataPartida;
    }
    /* ROTA DO VOO*/
    private Aeroporto origem;

    @OneToOne
    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto oneToOne) {
        this.origem = oneToOne;
    }

    private Aeroporto destino;

    @OneToOne
    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }
    /*                                                                                          */

    private Aeronave aeronave;

    @OneToOne//(optional = false)
    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
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

    private List<Assento> assentos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voo")
    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }
}
