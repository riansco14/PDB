package control;

import DAO.EmpresaDAO;
import Utils.Utils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Empresa;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Doda on 27/02/2017.
 */
public class cadEmpresaController implements Initializable {

    @FXML
    private Text meuLabel;

    @FXML
    public TextField nomeEmpresa;

    @FXML
    private Button salvarButton;

    @FXML
    private Button voltarButton;

    private String acao;
    private Integer idEmpresa;


    public void limparCampos(){
        this.nomeEmpresa.clear();
        this.nomeEmpresa.requestFocus();
    }

    public void salvarCadastro(){

        if (!nomeEmpresa.getText().isEmpty()){

            if (this.acao==""){

                new EmpresaDAO().inserir(new Empresa(nomeEmpresa.getText().toUpperCase()));
                Utils.mensagem("Mensagem para Você.","Operação realizada com sucesso !");
                limparCampos();

            }
            else
            {
                new EmpresaDAO().update(new Empresa(this.idEmpresa,nomeEmpresa.getText().toUpperCase()));
                Utils.mensagem("Mensagem para Você.","Operação realizada com sucesso !");
                voltarTela();
            }


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

    public Text getMeuLabel(){
        return this.meuLabel;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
