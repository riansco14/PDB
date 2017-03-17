package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.ProdutoVooNegocio;
import util.Dialogs;
import util.ExceptionGeneric;
import util.ValidationField;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PVooTelaInsert {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField fieldValorEconomico;

    @FXML
    private TextField fieldValorExecutivo;

    @FXML
    private DatePicker fieldDataPartida;

    @FXML
    private DatePicker fieldDataChegada;

    @FXML
    private Button buttonAeronave;

    @FXML
    private Button buttonAeroOrigem;

    @FXML
    private Label labelAeronave;

    @FXML
    private Label labelAeroOrigem;

    @FXML
    private Button buttonAeroDestino;

    @FXML
    private Label labelAeroDestino;

    private int idAeronave;
    private long idAeroportoOrigem;
    private long idAeroportoDestino;

    @FXML
    void buttonAeroDestino(ActionEvent event) {
        idAeroportoDestino=new Integer(Dialogs.showInput("Insira o ID da tripulação","Insira o ID da tripulação",""));
        labelAeroDestino.setText("ID:"+idAeroportoDestino);
    }

    @FXML
    void buttonAeroOrigem(ActionEvent event) {
        idAeroportoOrigem=new Integer(Dialogs.showInput("Insira o ID da tripulação","Insira o ID da tripulação",""));
        labelAeroOrigem.setText("ID:"+idAeroportoOrigem);
    }

    @FXML
    void buttonAeronave(ActionEvent event) {
        idAeronave=new Integer(Dialogs.showInput("Insira o ID da tripulação","Insira o ID da tripulação",""));
        labelAeronave.setText("ID:"+idAeronave);
    }

    @FXML
    void buttonInserir(ActionEvent event) {
        LocalDate localDate = fieldDataPartida.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dataPartida = Date.from(instant);
        localDate = fieldDataChegada.getValue();
        instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dataChegada = Date.from(instant);


        ProdutoVooNegocio negocio=new ProdutoVooNegocio();

        try {
            ValidationField.isEmptyAllFields(fieldValorEconomico,fieldValorExecutivo);
            negocio.criarProdutoVooSemEscala(new Double(fieldValorEconomico.getText()),new Double(fieldValorExecutivo.getText())
                    ,dataPartida,dataChegada,idAeroportoDestino,idAeroportoOrigem,idAeronave);

        } catch (ExceptionGeneric exceptionGeneric) {
            Dialogs.showError(exceptionGeneric.getMessage(),exceptionGeneric.getMessage(),"");
        }

    }

}
