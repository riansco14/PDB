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
public class Estado {
    private Collection<Cidade> cidades;

    @OneToMany(mappedBy = "test")
    public Collection<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Collection<Cidade> cidades) {
        this.cidades = cidades;
    }

    private long id;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
