
package main;

import java.io.IOException;

import DAO.AeronaveDAO;
import DAO.PassageiroDAO;
import javafx.animation.KeyValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Aeronave;
import model.Empresa;
import model.Passageiro;
import model.Tripulacao;
import util.Location;

public class Main extends Application {
	public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
    	this.stage=stage;
    	
        Parent root = FXMLLoader.load(getClass().getResource(Location.TELA_PASSAGEIRO_CRUD.toString()));
        Scene scene = new Scene(root);
     //   scene.getStylesheets().add(Location.ESTILO_CSS.toString());
        stage.setScene(scene);
        scene.setFill(new Color(0, 0, 0, 0));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();   
    }
    public static void setSceneAdmin() throws IOException{
    	 Parent root = FXMLLoader.load(Main.class.getResource(Location.TELA_GERENCIADORA.toString()));
         Scene scene = new Scene(root);
//         scene.getStylesheets().add(Location.ESTILO_CSS.toString());
         stage.setScene(scene);
         stage.show();   
         
         //Centralizar
         Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
         stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
         stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
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
    	
    	aeronaveDAO.inserir(aeronave);*/
    	
    	Passageiro passageiro=new Passageiro();
    	passageiro.setCpf(123);
    	passageiro.setNome("Markin");
    	
    	new PassageiroDAO().inserir(passageiro);
    	
        launch(args);
    }
    
}