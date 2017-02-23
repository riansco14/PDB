package model;

import javax.persistence.*;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Assento {

    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int idAssento) {
        this.id = idAssento;
    }

    private int classe;

    @Basic
    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    private boolean estado;

    @Basic
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    private Bilhete numBilhete;

    @OneToOne(mappedBy = "assento")
    public Bilhete getNumBilhete() {
        return numBilhete;
    }

    public void setNumBilhete(Bilhete numBilhete) {
        this.numBilhete = numBilhete;
    }

    private int numAssento;

    @Basic
    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }
}
