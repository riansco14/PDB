package DAO;

import DAO.Endereco.MunicipioDAO;
import model.*;
import model.Endereco.Endereco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by RIAN on 10/01/2017.
 */
public class Main2 {
    public static void main(String[] args) {
    	new VooDAO().inserir(popularVoo());



    }
    public static Voo popularVoo(){
        Voo voo=new Voo();

        ArrayList<Assento> assentos=new ArrayList<>();
        for (int i=0;i<10;i++){
            Assento assento=new Assento();
//            assento.setClasse(1);
            assento.setNumBilhete(null);
            assento.setNumAssento(i);
            assento.setVoo(voo);
            assentos.add(assento);

        }
        voo.setAssentos(assentos);

        voo.setAeronave(popularAeronave());
        voo.setDestino(popularAeroporto());
        voo.setOrigem(popularAeroporto());
        Date date=new Date(2000,10,10);
        voo.setDataChegada(date);
        voo.setDataPartida(date);

       return voo;
    }

    public  static Aeronave popularAeronave(){
        Aeronave aeronave=new Aeronave();
        aeronave.setNome("Aeromarkin");
        aeronave.setTripulacao(new TripulacaoDAO().listar().get(0));
        aeronave.setCompanhia(new EmpresaDAO().listar().get(0));
        return aeronave;
    }
/*
    public static Rota popularRota(){
        Rota rota=new Rota();
        rota.setNome("Rota");
        rota.setDestino(popularAeroporto());
        rota.setOrigem(popularAeroporto());
        return rota;
    }*/
    public static Aeroporto popularAeroporto(){
        Aeroporto aeroporto=new Aeroporto();
        aeroporto.setEndereco(new Endereco("Adress","Adress","Adress","Adress","Adress",new MunicipioDAO().localizar(new Long(1100015))));
        aeroporto.setDescricao("setDescricao");
//        aeroporto.setEmpresa(new Empresa().build("Empresa"));
        return aeroporto;
    }
    public static Tripulacao popularTripulacao(){
        Tripulacao tripulacao=new Tripulacao();
        tripulacao.setDescricao("Descricao");
        List<Funcionario> funcionarios=new ArrayList<>();
        funcionarios.add(popularFuncionario());
        tripulacao.setFuncionarios(funcionarios);
        return tripulacao;
    }
    public static Funcionario popularFuncionario(){
        Funcionario funcionario=new Funcionario();
        List<Endereco> enderecos=new ArrayList<>();
        Long randomNum=new Random().nextLong();
        //enderecos.add(new Endereco().build("Adress","Adress","Adress","Adress","Adress",10));
//        funcionario.build(enderecos,randomNum,"nome","email","12312","markin",randomNum);
        return funcionario;
    }

}
