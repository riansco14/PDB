package control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.App;
import negocio.PassageiroNegocio;
import util.Dialogs;
import util.ExceptionGeneric;
import util.Location;
import util.ValidationField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserLoginController implements Initializable {

    @FXML
    private ComboBox<String> cmbAdmin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private TextField fieldUserName;

    @FXML
    void actionLogin(ActionEvent event) {
        try {
            ValidationField.isEmptyAllFields(fieldUserName, fieldPassword);
            switch (cmbAdmin.getSelectionModel().getSelectedItem()){
                case "Usuario":
                    PassageiroNegocio negocio=new PassageiroNegocio();
                    if(negocio.autenticarPassageiro(new Long(fieldUserName.getText()), fieldPassword.getText()))
                        App.setScene(Location.TELA_USER_MAIN.toString());
                        break;
                case "Administrador":

                    break;
            }

        } catch (ExceptionGeneric exceptionGeneric) {
            Dialogs.showError("Error",exceptionGeneric.getMessage(),
                    exceptionGeneric.getMessage());
        }


    }

    @FXML
    void actionSair(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void actionCadastrar(MouseEvent event) {
        App.setScene(Location.TELA_USER_CADASTRO.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbAdmin.getItems().addAll("Usuario", "Administrador");
    }


}
