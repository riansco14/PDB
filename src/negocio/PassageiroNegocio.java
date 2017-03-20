package negocio;


import DAO.PassageiroDAO;
import model.Endereco.Endereco;
import model.Endereco.Municipio;
import model.Passageiro;
import util.ExceptionGeneric;

import java.util.ArrayList;

/**
 * Created by RIAN on 26/02/2017.
 */
public class PassageiroNegocio {
    private Passageiro pessoa;
    private String codigoEmail = "123";

    public boolean criarPessoa(String nome, Long cpf, String email, String telefone, String senha, String senha2) throws ExceptionGeneric {
        if (pessoa != null) {
            pessoa.setNome(nome);
            if (isExiste(cpf))
                throw new ExceptionGeneric(ExceptionGeneric.CPF_CADASTRADO);
            pessoa.setCpf(cpf);
            pessoa.setEmail(email);
            pessoa.setTelefone(telefone);
            if (!senha.equals(senha2))
                throw new ExceptionGeneric(ExceptionGeneric.SENHA2_ERRADA);
            pessoa.setSenha(senha);
            return true;
        } else {
            pessoa = new Passageiro();
            pessoa.setEnderecos(new ArrayList<Endereco>());
        }
        return false;
    }

    public void adicionarEndereco(String CEP, String bairro, String rua, String complemento, String numero, Municipio municipio) {
        if (pessoa.getEnderecos() != null) {
            Endereco endereco = new Endereco();
            endereco.setCep(CEP);
            endereco.setBairro(bairro);
            endereco.setComplemento(complemento);
            endereco.setMunicipio(municipio);
            endereco.setLogradouro(rua);
            endereco.setNumero(numero);

            pessoa.getEnderecos().add(endereco);
        }

    }

    public boolean isExisteEnderecos() {
        for (Endereco passageiro : pessoa.getEnderecos()
                ) {
            System.out.println(passageiro.getBairro());
        }
        if (pessoa.getEnderecos().size() > 0)
            return true;
        return false;
    }


    public boolean salvarPessoa(String codigo) throws ExceptionGeneric {
        if (codigo.equals(codigoEmail))
           return new PassageiroDAO().inserir(pessoa);
        else
            throw new ExceptionGeneric(ExceptionGeneric.CODIGO_EMAIL_INVALIDO);
    }

    public boolean autenticarPassageiro(Long cpf, String senha) throws ExceptionGeneric {
        if (!isExiste(cpf))
            throw new ExceptionGeneric(ExceptionGeneric.PASSAGEIRO_N_EXISTE);
        else {
            PassageiroDAO passageiroDAO = new PassageiroDAO();
            Passageiro passageiro = passageiroDAO.localizar(cpf);
            if (passageiro.getSenha().equals(senha))
                return true;
        }
        return false;
    }


    public boolean isExiste(Long CPF) {
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        if (passageiroDAO.localizar(CPF) != null)
            return true;
        return false;
    }

}
