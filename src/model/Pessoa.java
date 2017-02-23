package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by RIAN on 10/11/2016.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
public abstract class Pessoa implements Serializable{
    public Pessoa build(Collection<Endereco> enderecos, long cpf, String nome, String email, String telefone, String senha, long rg) {
        this.enderecos = enderecos;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.rg = rg;
        return this;
    }

    private String tipo;

    @Column(insertable=false, updatable=false)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private Collection<Endereco> enderecos;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Collection<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    private long cpf;

    @Id
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    private String nome;

    @Basic
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String email;

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String telefone;

    @Basic
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String senha;

    @Basic
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private long rg;

    @Basic
    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }
}
