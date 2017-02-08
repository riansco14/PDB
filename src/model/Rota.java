package model;

import javax.persistence.*;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Rota {
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

    private long id;

    @GeneratedValue
    @Id
    public long getId() {
        return id;
    }

    public void setId(long idRota) {
        this.id = idRota;
    }

    private String nome;

    @Basic
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
