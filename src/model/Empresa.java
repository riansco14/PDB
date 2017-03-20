package model;

import javax.persistence.*;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Empresa {

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Empresa() {}

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
}
