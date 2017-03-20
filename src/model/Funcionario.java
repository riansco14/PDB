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
    public Funcionario() {
    }

    public Funcionario(List<Endereco> enderecos, long cpf, String nome, String email, String telefone, String senha, long rg, String cargo, String contaCorrente) {
        super(enderecos, cpf, nome, email, telefone, senha, rg);
        this.cargo = cargo;
        this.contaCorrente = contaCorrente;
    }

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


}
