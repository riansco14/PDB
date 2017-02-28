package control;

import DAO.EmpresaDAO;
import Utils.Utils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Empresa;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Doda on 27/02/2017.
 */
public class cadEmpresaController implements Initializable {

    @FXML
    private TextField nomeEmpresa;

    @FXML
    private Button salvarButton;

    @FXML
    private Button voltarButton;



    public void salvarCadastro(){

        if (!nomeEmpresa.getText().isEmpty()){
            new EmpresaDAO().inserir(new Empresa(nomeEmpresa.getText().toUpperCase()));
            Utils.mensagem("Mensagem para Você.","Operação realizada com sucesso !");

        }
        else{
            Utils.mensagemError("Mensagem pra você.", "É preciso preencher o nome da empresa !");
        }

    }


    public void voltarTela(){
        Stage stage = (Stage)voltarButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.nomeEmpresa.textProperty().addListener((ov, oldValue, newValue) ->{
            this.nomeEmpresa.setText(newValue.toUpperCase());
        } );

    }

    public TextField getNomeEmpresa() {
        return nomeEmpresa;
    }
}
