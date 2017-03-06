package main;/**
 * Created by RIAN on 14/11/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.Location;

import java.io.IOException;

public class App extends Application {
    public static Stage stage;
    public static void main(String[] args) {


        launch(args);

//        EmpresaDAO empresa=new EmpresaDAO();
//        empresa.inserir(new Empresa());
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
