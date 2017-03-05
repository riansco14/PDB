package control;

import DAO.Endereco.EstadoDAO;
import DAO.Endereco.MunicipioDAO;
import DAO.Endereco.PaisDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import model.Pessoa;
import model.Endereco.Estado;
import model.Endereco.Municipio;
import model.Endereco.Pais;
import negocio.PassageiroNegocio;
import util.Dialogs;
import util.ExceptionGeneric;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by RIAN on 04/03/2017.
 */

public class UserCadastroController implements Initializable {

	@FXML
	private TextField fieldNome;

	@FXML
	private TextField fieldCpf;

	@FXML
	private TextField fieldEmail;

	@FXML
	private TextField fieldTelefone;

	@FXML
	private PasswordField fieldPassword;

	@FXML
	private PasswordField fieldPasswordTwo;

	@FXML
	private TextField fieldCEP;

	@FXML
	private TextField fieldBairro;

	@FXML
	private TextField fieldRua;

	@FXML
	private TextField fieldComplemento;

	@FXML
	private TextField fieldNumero;

	@FXML
	private ComboBox<Pais> boxPais;

	@FXML
	private ComboBox<Estado> boxEstado;

	@FXML
	private ComboBox<Municipio> boxMunicipio;

	@FXML
	private ComboBox<Integer> boxArrayEnderecos;

	@FXML
	private TextField fieldConfirmar;

	@FXML
	private Button buttonConfirmar;

	@FXML
	private TabPane tabPane;

	PassageiroNegocio negocio = new PassageiroNegocio();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Pais> paises = new PaisDAO().listar();
		boxPais.getItems().addAll(paises);
	}

	@FXML
	void actionBoxPais(ActionEvent event) {
		Long id = boxPais.getSelectionModel().getSelectedItem().getId();
		List<Estado> estados = new EstadoDAO().listarPorIdPais(id);
		boxEstado.getItems().addAll(estados);
		boxEstado.setDisable(false);
	}

	@FXML
	void actionBoxEstado(ActionEvent event) {
		Long id = boxEstado.getSelectionModel().getSelectedItem().getId();
		List<Municipio> estados = new MunicipioDAO().listarPorIdEstado(id);
		boxMunicipio.getItems().addAll(estados);
		boxMunicipio.setDisable(false);
	}

	@FXML
	void actionButtonConfirmar(ActionEvent event) {
		try {
			negocio.salvarPessoa(fieldConfirmar.getText());
		} catch (ExceptionGeneric e) {
			Dialogs.showError("Error", e.getMessage(), "");
		}
	}

	@FXML
	void actionButtonProxDadosPessoais(ActionEvent event) {
		try {
			negocio.criarPessoa(fieldNome.getText(), new Long(fieldCpf.getText()), fieldEmail.getText(),
					fieldTelefone.getText(), fieldPassword.getText(), fieldPasswordTwo.getText());
			tabPane.getSelectionModel().getSelectedItem().setDisable(true);
		} catch (NumberFormatException | ExceptionGeneric e) {

		}
		tabPane.getSelectionModel().select(1);
		tabPane.getSelectionModel().getSelectedItem().setDisable(false);

	}

	@FXML
	void actionButtonProxEnderecos(ActionEvent event) {
		tabPane.getSelectionModel().select(2);
		tabPane.getSelectionModel().getSelectedItem().setDisable(false);

	}

	@FXML
	void actionButtonAddEndereco(ActionEvent event) {
		
		negocio.adicionarEndereco(fieldCEP.getText(), fieldBairro.getText(), fieldRua.getText(),
				fieldComplemento.getText(), fieldNumero.getText(), boxMunicipio.getSelectionModel().getSelectedItem());
	}
}
