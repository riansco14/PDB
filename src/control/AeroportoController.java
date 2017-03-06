package control;


import DAO.AeroportoDAO;
import DAO.EmpresaDAO;
import Utils.Utils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Aeroporto;
import model.Empresa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Doda on 27/02/2017.
 */
public class AeroportoController implements Initializable {

    @FXML
    private javafx.scene.control.TableView<Aeroporto> tabela;
    @FXML private TableColumn<Aeroporto, Integer> idAeroporto;
    @FXML private TableColumn<Aeroporto, String> nomeAeroporto;
    @FXML private TableColumn<Aeroporto, String> descricaoAeroporto;
    @FXML private TextField textoConsulta;
    @FXML private Button cadastrarButton;
    @FXML private Button alterarButton;
    @FXML private Button voltarButton;
    @FXML private Button excluirButton;
    private Stage windows;
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idAeroporto.setCellValueFactory(new PropertyValueFactory<Aeroporto, Integer>("id"));
        nomeAeroporto.setCellValueFactory(new PropertyValueFactory<Aeroporto, String>("nome"));
        descricaoAeroporto.setCellValueFactory(new PropertyValueFactory<Aeroporto, String>("descricao"));

        tabela.getItems().setAll(AeroportoDAO.exibirAeroporto());

        this.textoConsulta.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tabela.setItems(AeroportoDAO.exibirTodasByNome(newValue.toUpperCase()));

                System.out.print(newValue);
            }
        });

    }

    public void exibirCadastro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadAeroporto.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Cadastro de Aeroporto");
        CadAeroportoController cadAeroportoController = (CadAeroportoController)loader.getController();
        cadAeroportoController.setAcao("");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void alterarCadastro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadAeroporto.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Cadastro de Aeroporto");
        CadAeroportoController cadAeroportoController = (CadAeroportoController)loader.getController();
        cadAeroportoController.setAcao("ALTERAR");
        cadAeroportoController.getNomeAeroporto().setText(tabela.getSelectionModel().getSelectedItem().getNome());
        cadAeroportoController.getDescricaoAeroporto().setText(tabela.getSelectionModel().getSelectedItem().getDescricao());
        cadAeroportoController.setIdEmpresa(tabela.getSelectionModel().getSelectedItem().getEmpresa().getId());
        cadAeroportoController.getEnderecoText().setText(tabela.getSelectionModel().getSelectedItem().getEndereco().getRua());
        cadAeroportoController.getNumeroText().setText(String.valueOf(tabela.getSelectionModel().getSelectedItem().getEndereco().getNumero()));
        cadAeroportoController.getBairroText().setText(tabela.getSelectionModel().getSelectedItem().getEndereco().getCidade());
        //cadAeroportoController.getCepText().setText(tabela.getSelectionModel().getSelectedItem().getEndereco().get);
        cadAeroportoController.getCidadeText().setText(tabela.getSelectionModel().getSelectedItem().getEndereco().getCidade());
        cadAeroportoController.getCidadeText().setText(tabela.getSelectionModel().getSelectedItem().getEndereco().getCidade());
        cadAeroportoController.getPaisText().setText(tabela.getSelectionModel().getSelectedItem().getEndereco().getPais());
        cadAeroportoController.setIdAeroporto(tabela.getSelectionModel().getSelectedItem().getId());
        cadAeroportoController.setIdEndereco(tabela.getSelectionModel().getSelectedItem().getEndereco().getId());

        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

    public void excluirCadastro(){

        if (Utils.pergunta("Pergunta","Deseja excluir o registro selecionado ?")) {
            new EmpresaDAO().DeletePorNome(tabela.getSelectionModel().getSelectedItem().getNome());

        }

    }


    public void voltarTela(){
        Stage stage = (Stage)voltarButton.getScene().getWindow();
        stage.close();
    }

}
