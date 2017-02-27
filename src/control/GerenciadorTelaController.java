package control;

import DAO.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenciadorTelaController  {

    @FXML
    private AnchorPane loadBaju;

    @FXML
    private Label lblAdmin;

    @FXML
    private StackPane workspace;

    @FXML
    void menuItemExit(ActionEvent event) {

    }

}
