/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Utils.Utils;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Herudi
 */
public class EnderecoController implements Initializable {
    @FXML
    private AnchorPane paneTabel;
    @FXML
    private TextField enderecoText,numeroText,complementoText,bairroText,cepText,cidadeText,paisText;
    @FXML
    private ComboBox<String> ufCombo;
    @FXML
    private Button selecionarCidadesButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ufCombo.setPromptText("Selecione");
        ufCombo.getItems().addAll("", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO");
    }  
    
    private void clear(){
        enderecoText.clear();
        numeroText.clear();
        complementoText.clear();
        bairroText.clear();
        cepText.clear();
        cidadeText.clear();
        paisText.clear();
        enderecoText.requestFocus();
    }


    @FXML
    private void numeroText(KeyEvent event) {
        char[] data = numeroText.getText().toCharArray();
        boolean valid = true;
        for (char c : data) {
            if (!Character.isDigit(c)) {
                valid = false;
                break;
            }
        }
        if (!valid) {
            Utils.mensagemError("Error","Somente números !");
            numeroText.clear();
            numeroText.requestFocus();
        }
    }


    public TextField getEnderecoText() {
        return enderecoText;
    }

    public TextField getNumeroText() {
        return numeroText;
    }

    public TextField getComplementoText() {
        return complementoText;
    }

    public TextField getBairroText() {
        return bairroText;
    }

    public TextField getCepText() {
        return cepText;
    }

    public TextField getCidadeText() {
        return cidadeText;
    }

    public TextField getPaisText() {
        return paisText;
    }

    public ComboBox<String> getUfCombo() {
        return ufCombo;
    }

    public Button getSelecionarCidadesButton() {
        return selecionarCidadesButton;
    }

    public void setEnderecoText(TextField enderecoText) {
        this.enderecoText = enderecoText;
    }

    public void setNumeroText(TextField numeroText) {
        this.numeroText = numeroText;
    }

    public void setComplementoText(TextField complementoText) {
        this.complementoText = complementoText;
    }

    public void setBairroText(TextField bairroText) {
        this.bairroText = bairroText;
    }

    public void setCepText(TextField cepText) {
        this.cepText = cepText;
    }

    public void setCidadeText(TextField cidadeText) {
        this.cidadeText = cidadeText;
    }

    public void setPaisText(TextField paisText) {
        this.paisText = paisText;
    }

    public void setUfCombo(ComboBox<String> ufCombo) {
        this.ufCombo = ufCombo;
    }

    public void setSelecionarCidadesButton(Button selecionarCidadesButton) {
        this.selecionarCidadesButton = selecionarCidadesButton;
    }
}
    

