package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Voo {

    public Voo(Aeroporto origem, Aeroporto destino, Aeronave aeronave, Date dataChegada, Date dataPartida) {
        this.origem = origem;
        this.destino = destino;
        this.aeronave = aeronave;
        this.estado = VooEstadoEnum.CONFIRMADO;
        this.dataChegada = dataChegada;
        this.dataPartida = dataPartida;
        this.assentos=ocuparAssentos();
    }

    public Voo() {}

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

    private VooEstadoEnum estado;

    @Basic
    public VooEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(VooEstadoEnum estado) {
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

    private List<Assento> ocuparAssentos(){
        List<Assento> assentos=new ArrayList<Assento>();
        int numAssento=0;
        for (int i=0;i<this.aeronave.getNumAssentosExe();i++){
            numAssento++;
            assentos.add(new Assento(AssentoClasseEnum.EXECUTIVO,false,null,numAssento,this));
        }

        for (int i=0;i<this.aeronave.getNumAssentosEco();i++){
            numAssento++;
            assentos.add(new Assento(AssentoClasseEnum.ECONOMICO,false,null,numAssento,this));
        }

        return assentos;
    }
}
