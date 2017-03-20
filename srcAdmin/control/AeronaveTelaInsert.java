package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.AeronaveNegocio;
import util.Dialogs;
import util.ExceptionGeneric;
import util.ValidationField;

public class AeronaveTelaInsert {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField fieldNome;

    @FXML
    private TextField fieldNumAEco;

    @FXML
    private TextField fieldNumAExe;

    @FXML
    private TextField fieldNumATotal;

    @FXML
    private Button buttonTripulacao;

    @FXML
    private Button buttonEmpresa;

    @FXML
    private Label labelTripulacao;

    @FXML
    private Label labelEmpresa;

    private int idCompanhia;
    private int idTripulacao;


    @FXML
    void buttonInserir(ActionEvent event) {
        AeronaveNegocio negocio=new AeronaveNegocio();
        try {
            ValidationField.isEmptyAllFields(fieldNome,fieldNumAEco,fieldNumAExe,fieldNumATotal);
            negocio.criarAeronave(fieldNome.getText(),new Integer(fieldNumAEco.getText()),new Integer(fieldNumAExe.getText())
                    ,new Integer(fieldNumATotal.getText()),idCompanhia,idTripulacao);
        } catch (ExceptionGeneric exceptionGeneric) {
            Dialogs.showError(exceptionGeneric.getMessage(),exceptionGeneric.getMessage(),"");
        }

    }
    @FXML
    void buttonTripulacao(ActionEvent event) {
        idTripulacao=new Integer(Dialogs.showInput("Insira o ID da tripulação","Insira o ID da tripulação",""));
        labelTripulacao.setText("ID:"+idTripulacao);
    }
    @FXML
    void buttonEmpresa(ActionEvent event) {
        idCompanhia=new Integer(Dialogs.showInput("Insira o ID da companhia","Insira o ID da companhia",""));
        labelEmpresa.setText("ID:"+idCompanhia);
    }

}
