package model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Tripulacao {
    private Collection<Funcionario> funcionarios;

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int idTripulacao) {
        this.id = idTripulacao;
    }

    private String descricao;

    @Basic
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private String horasVoo;

    @Basic
    public String getHorasVoo() {
        return horasVoo;
    }

    public void setHorasVoo(String horasVoo) {
        this.horasVoo = horasVoo;
    }
}
