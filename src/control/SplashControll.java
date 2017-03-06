package control;

/**
 * Created by Doda on 05/03/2017.
 */
import animations.FadeInLeftTransition;
import animations.FadeInRightTransition;
import animations.FadeInTransition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Tester;
import org.springframework.context.ApplicationContext;

/**
 * FXML Controller class
 *
 * @author Herudi
 */
public class SplashControll implements Initializable {
    @FXML
    private Text lblWelcome;
    @FXML
    private Text lblRudy;
    @FXML
    private VBox vboxBottom;
    @FXML
    private Label lblClose;
    Stage stage;
    @FXML
    private ImageView imgLoading;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new FadeInLeftTransition(lblWelcome).play();
        new FadeInRightTransition(lblRudy).play();
        new FadeInTransition(vboxBottom).play();

        lblClose.setOnMouseClicked((MouseEvent event) -> {
            Platform.exit();
            System.exit(0);
        });


        new SplashScreen().start();

    }


    class SplashScreen extends Thread{

        @Override
        public void run() {

            try {
                Thread.sleep(5000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation( Tester.class.getResource("/view/login.fxml"));
                        Parent root = null;
                        try {
                            root = loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(scene);
                        stage.show();

                        Stage cenario = (Stage)lblClose.getScene().getWindow();
                        cenario.close();

                    }
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}