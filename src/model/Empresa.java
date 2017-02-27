package model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by RIAN on 10/11/2016.
 * Modify by Francisco Bezerra on 27/02/2017
 */

@Entity
public class Empresa {
    private int id;

    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public Empresa(String nome) {
        this.nome = nome;
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
}
