package control;

import DAO.EmpresaDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Empresa;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Doda on 06/03/2017.
 */
public class LocalizarEmpresasController implements Initializable {

    private Integer idEmpresaRetorno;
    private String nomeEmpresaRetorno;

    public static boolean retorno;

    @FXML
    private TextField nomeText;

    @FXML
    private javafx.scene.control.TableView<Empresa> tabela;
    @FXML private TableColumn<Empresa, Integer> idEmpresa;
    @FXML private TableColumn<Empresa, String> nomeEmpresa;

    @FXML private Button selecionarButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idEmpresa.setCellValueFactory(new PropertyValueFactory<Empresa, Integer>("id"));
        nomeEmpresa.setCellValueFactory(new PropertyValueFactory<Empresa, String>("nome"));
        tabela.getItems().setAll(EmpresaDAO.exibirEmpresas());

        this.nomeText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tabela.setItems(EmpresaDAO.exibirTodasByNome(newValue.toUpperCase()));
            }
        });


    }

    public TextField getNomeText() {
        return nomeText;
    }

    public void setNomeText(TextField nomeText) {
        this.nomeText = nomeText;
    }

    public TableView<Empresa> getTabela() {
        return tabela;
    }

    public void setTabela(TableView<Empresa> tabela) {
        this.tabela = tabela;
    }

    public Integer getIdEmpresaRetorno() {
        return idEmpresaRetorno;
    }

    public String getNomeEmpresaRetorno() {
        return nomeEmpresaRetorno;
    }

    @FXML
    public void selecionarEmpresa(){

        if (tabela.getSelectionModel().getSelectedItem() != null){
            this.idEmpresaRetorno = tabela.getSelectionModel().getSelectedItem().getId();
            this.nomeEmpresaRetorno = tabela.getSelectionModel().getSelectedItem().getNome();
            Stage cenario = (Stage)selecionarButton.getScene().getWindow();
            retorno=true;
            cenario.close();
        }

    }
}
