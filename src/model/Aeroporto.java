package model;

import model.Endereco.Endereco;

import javax.persistence.*;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Aeroporto {
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private String nome;

    @Basic
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long getId() {
        return id;
    }

    public void setId(long idAeroporto) {
        this.id = idAeroporto;
    }

    private String descricao;

    @Basic
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private Empresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
