package control;


import DAO.EmpresaDAO;
import Utils.Utils;
import componentes.TextFieldCustom;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Tester;
import model.Empresa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Doda on 27/02/2017.
 */
public class EmpresasController implements Initializable {

    @FXML
    private javafx.scene.control.TableView<Empresa> tabela;
    @FXML private TableColumn<Empresa, String> nomeEmpresa;
    @FXML private TextField textoConsulta;
    @FXML private Button cadastrarButton;
    @FXML private Button alterarButton;
    @FXML private Button voltarButton;
    @FXML private Button excluirButton;
    private Stage windows;
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeEmpresa.setCellValueFactory(new PropertyValueFactory<Empresa, String>("nome"));
        tabela.getItems().setAll(EmpresaDAO.exibirEmpresas());

        this.textoConsulta.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tabela.setItems(EmpresaDAO.exibirTodasByNome(newValue.toUpperCase()));

                System.out.print(newValue);
            }
        });

    }

    public void exibirCadastro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cadEmpresa.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNIFIED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Cadastro de empresa");
//        cadEmpresaController cadEmpresaController = (cadEmpresaController)loader.getController();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void alterarCadastro() throws IOException {

        if (tabela.getSelectionModel().getSelectedItem() != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cadEmpresa.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNIFIED);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Cadastro de empresa");
            cadEmpresaController cadEmpresaController = (cadEmpresaController) loader.getController();
            cadEmpresaController.getMeuLabel().setText("Alterando o registro selecionado");
            cadEmpresaController.setAcao("ALTERAR");
            cadEmpresaController.setIdEmpresa(tabela.getSelectionModel().getSelectedItem().getId());
            cadEmpresaController.getNomeEmpresa().setText(tabela.getSelectionModel().getSelectedItem().getNome());
            stage.setScene(new Scene(root));
            stage.showAndWait();
            System.out.print(cadEmpresaController.getNomeEmpresa().getText());
        }
    }

    public void excluirCadastro(){

        if (tabela.getSelectionModel().getSelectedItem() != null) {
            if (Utils.pergunta("Pergunta", "Deseja excluir o registro selecionado ?")) {
                new EmpresaDAO().DeletePorId(tabela.getSelectionModel().getSelectedItem().getId());

            }
        }

    }


    public void voltarTela(){
        Stage stage = (Stage)voltarButton.getScene().getWindow();
        stage.close();
    }

}
