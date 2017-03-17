
package main;

import DAO.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Empresa;
import model.Tripulacao;
import util.Location;

public class Main extends Application {
	public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
    	this.stage=stage;
    	
        Parent root = FXMLLoader.load(getClass().getResource(Location.TELA_PRODUTOVOO_INSERT.toString()));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Location.ESTILO_CSS.toString());
        stage.setScene(scene);
        scene.setFill(new Color(0, 0, 0, 0));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();   
    }


    public static void main(String[] args) {
    /*	AeronaveDAO aeronaveDAO=new AeronaveDAO();
    	Aeronave aeronave=new Aeronave();
    	aeronave.setNome("Markin");
    	aeronave.setCompanhia(new Empresa());
    	aeronave.setNumAssentosEco(10);
    	aeronave.setNumAssentosExe(10);
    	aeronave.setNumAssentosTotal(10);
    	aeronave.setTripulacao(new Tripulacao());
    	
    	aeronaveDAO.inserir(aeronave);
    	
    	Passageiro passageiro=new Passageiro();
    	passageiro.setCpf(123);
    	passageiro.setNome("Markin");
    	
    	new PassageiroDAO().inserir(passageiro);*/

        new EmpresaDAO().inserir(new Empresa());
        new TripulacaoDAO().inserir(new Tripulacao());
        new AeroportoDAO().inserir(Main2.popularAeroporto());
        new AeronaveDAO().inserir(Main2.popularAeronave());
        launch(args);
    }
    
}
