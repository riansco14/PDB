package DAO;

import model.*;
import model.Endereco.Endereco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by RIAN on 10/01/2017.
 */
public class Main2 {
    public static void main(String[] args) {

        VooDAO vooDAO=new VooDAO();
        vooDAO.inserir(popularVoo());
        Voo voo=vooDAO.localizar(23);

        System.out.println(voo.getAssentos().size());

    }
    public static Voo popularVoo(){
        Voo voo=new Voo();

        ArrayList<Assento> assentos=new ArrayList<>();
        for (int i=0;i<10;i++){
            Assento assento=new Assento();
            assento.setClasse(1);
            assentos.add(assento);
        }
        voo.setAssentos(assentos);

        voo.setAeronave(popularAeronave());
        voo.setDestino(popularAeroporto());
        voo.setOrigem(popularAeroporto());
        Date date=new Date(2000,10,10);
        voo.setDataChegada(date);
        voo.setDataPartida(date);
        voo.setEstado(true);

       return voo;
    }

    public  static Aeronave popularAeronave(){
        Aeronave aeronave=new Aeronave();
        aeronave.setNome("Aeromarkin");
        aeronave.setTripulacao(popularTripulacao());
        aeronave.setCompanhia(new Empresa().build("Empresa"));
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
       // aeroporto.setEndereco(new Endereco().build("Adress","Adress","Adress","Adress","Adress",10));
        aeroporto.setDescricao("setDescricao");
        aeroporto.setEmpresa(new Empresa().build("Empresa"));
        return aeroporto;
    }
    public static Tripulacao popularTripulacao(){
        Tripulacao tripulacao=new Tripulacao();
        tripulacao.setDescricao("Descricao");
        Collection<Funcionario> funcionarios=new ArrayList<>();
        funcionarios.add(popularFuncionario());
        tripulacao.setFuncionarios(funcionarios);
        return tripulacao;
    }
    public static Funcionario popularFuncionario(){
        Funcionario funcionario=new Funcionario();
        Collection<Endereco> enderecos=new ArrayList<>();
    //    enderecos.add(new Endereco().build("Adress","Adress","Adress","Adress","Adress",10));
        long randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);
        funcionario.build(enderecos,randomNum,"nome","email","12312","markin",randomNum);
        return funcionario;
    }

}