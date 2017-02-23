package main;/**
 * Created by RIAN on 14/11/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    public static Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage=primaryStage;
        Parent root= null;
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/GerenciadorTela2.fxml"));
            root = loader.load();

            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
