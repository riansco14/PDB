package model.City;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by RIAN on 21/02/2017.
 */
@Entity
public class Pais {
    private Collection<Estado> estados;

    @OneToMany
    public Collection<Estado> getEstados() {
        return estados;
    }

    public void setEstados(Collection<Estado> estados) {
        this.estados = estados;
    }

    private int id;

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
