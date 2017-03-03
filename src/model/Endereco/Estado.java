package model.Endereco;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RIAN on 21/02/2017.
 */

@Entity
public class Estado implements Serializable {

    @Id
    private long id;
    private String descricao;
    private String uf;
    @OneToMany(mappedBy = "estado")
    private List<Municipio> municipios;
    @ManyToOne
    private Pais pais;

    public Estado() {
        this.municipios = new ArrayList<Municipio>();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Estado) {
            Estado outro = (Estado) obj;
            if (outro.getId().equals(this.id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return uf;
    }



}
