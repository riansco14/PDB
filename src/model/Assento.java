package model;

import javax.persistence.*;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Assento {

    public Assento() {
    }

    public Assento(AssentoClasseEnum classe, boolean estado, Bilhete numBilhete, int numAssento, Voo voo) {
        this.classe = classe;
        this.estado = estado;
        this.numBilhete = numBilhete;
        this.numAssento = numAssento;
        this.voo = voo;
    }

    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int idAssento) {
        this.id = idAssento;
    }

    private AssentoClasseEnum classe;

    @Enumerated(EnumType.ORDINAL)

    public AssentoClasseEnum getClasse() {
        return classe;
    }

    public void setClasse(AssentoClasseEnum classe) {
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

    @OneToOne(cascade = CascadeType.MERGE)
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


    private Voo voo;

    @ManyToOne
    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
    @Transient
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assento assento = (Assento) o;

        return numAssento == assento.numAssento;

    }
    @Transient
    @Override
    public int hashCode() {
        return numAssento;
    }
}
