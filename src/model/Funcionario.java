package model;

import model.Endereco.Endereco;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
@DiscriminatorValue("F")
public class Funcionario extends Pessoa {


    private String cargo;

    @Basic
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String funcao) {
        this.cargo = funcao;
    }

    private String contaCorrente;

    @Basic
    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Funcionario construtor(String cargo, String contaCorrente, List<Endereco> enderecos, long cpf, String nome, String email, String telefone, String senha, long rg) {
        this.setEnderecos(enderecos);
        this.setCpf(cpf);
        this.setCargo(cargo);
        this.setContaCorrente(contaCorrente);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setSenha(senha);
        this.setNome(nome);
        return this;
    }
}
