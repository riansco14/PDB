package main;/**
 * Created by RIAN on 14/11/2016.
 */

import DAO.*;
import DAO.Endereco.MunicipioDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import model.Endereco.Endereco;
import negocio.BilheteNegocio;
import negocio.ProdutoVooNegocio;
import util.ExceptionGeneric;
import util.Location;
import util.ValidationField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App extends Application {
    public static Stage stage;
    public static void main(String[] args)  {
        try {
            teste();
        } catch (ExceptionGeneric exceptionGeneric) {
            exceptionGeneric.printStackTrace();
        }


    }
    private static void teste() throws ExceptionGeneric {

        Empresa empresa=new Empresa("markin");
        EmpresaDAO empresaDAOdao=new EmpresaDAO();
        empresaDAOdao.inserir(empresa);

        Endereco endereco=new Endereco("markin","123","centro","casa","markin",new MunicipioDAO().localizar(new Long(2600104)));
        Aeroporto aeroporto=new Aeroporto(endereco,"Aeroporto de Recife","Melhor aeroporto",empresa);
        new AeroportoDAO().inserir(aeroporto);

        Endereco enderecoF=new Endereco("markin","123","centro","casa","markin",new MunicipioDAO().localizar(new Long(2600104)));
        List<Endereco> enderecos=new ArrayList<>();
        enderecos.add(enderecoF);

        Funcionario f=new Funcionario(enderecos,new Long(123),"Rico","email","12221","123",new Long(123),"cargo","banco");
        FuncionarioDAO funcionarioDAO=new FuncionarioDAO();
        funcionarioDAO.inserir(f);

        List<Funcionario> funcionarios=new ArrayList<Funcionario>();
        funcionarios.add(f);

        Tripulacao tripulacao=new Tripulacao();
        tripulacao.setFuncionarios(funcionarios);
        TripulacaoDAO tripulacaoDAO=new TripulacaoDAO();
        tripulacaoDAO.inserir(tripulacao);

        Aeronave aeronave=new Aeronave(tripulacao,"AeronaveMarkin",empresa,10,5,5);
        AeronaveDAO aeronaveDAO=new AeronaveDAO();
        aeronaveDAO.inserir(aeronave);


        Voo voo=new Voo(aeroporto,aeroporto,aeronave,new Date(),new Date());
        Voo voo2=new Voo(aeroporto,aeroporto,aeronave,new Date(),new Date());
        Voo voo3=new Voo(aeroporto,aeroporto,aeronave,new Date(),new Date());
        VooDAO vooDAO=new VooDAO();
        vooDAO.inserir(voo);
        vooDAO.inserir(voo2);
        vooDAO.inserir(voo3);

        Date dataPartida= ValidationField.getData(2017,03,20);
        Date dataChegada= ValidationField.getData(2017,03,21);
        ProdutoVooNegocio negocio=new ProdutoVooNegocio();
        negocio.criarProdutoVooSemEscala(new Double(123),new Double(123),dataPartida,dataChegada,aeroporto.getId(),aeroporto.getId(),voo.getId());
        negocio.criarProdutoVooSemEscala(new Double(123),new Double(123),dataPartida,dataChegada,aeroporto.getId(),aeroporto.getId(),voo.getId(),voo2.getId());
        negocio.criarProdutoVooSemEscala(new Double(123),new Double(123),dataPartida,dataChegada,aeroporto.getId(),aeroporto.getId(),voo2.getId());

        BilheteNegocio negocio1=new BilheteNegocio();
        negocio1.criarBilhete(123,1,new Date(),4);
        negocio1.criarBilhete(123,2,new Date(),3);

        //launch(args);

        AssentoDAO dao=new AssentoDAO();
        for (Assento a :dao.listarAssentosVagosPorIdProduto(1)) {
            System.out.println(a.getNumAssento()+"      "+a.getClasse());
        }

        for (Assento a :dao.listarAssentosVagosPorIdProduto(3)) {
            System.out.println(a.getNumAssento()+"      "+a.getClasse());
        }

        List<Produto_Voo> voos =  new ProdutoVooDAO().listarPVooPorAeroporto("Recife","Recife",ValidationField.getData(2017,03,20));
        for (Produto_Voo pv: voos) {
            System.out.println(pv.getId());
        }
    }

    @Override
    public void start(Stage primaryStage) {
        stage=primaryStage;
        Parent root= null;
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource(Location.TELA_USER_LOGIN.toString()));
            root = loader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            scene.setFill(new Color(0, 0, 0, 0));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void  setScene(String locationTela){
        Parent root= null;
        FXMLLoader loader=new FXMLLoader(App.class.getClassLoader().getClass().getResource(locationTela));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        scene.setFill(new Color(0, 0, 0, 0));
    }
}
