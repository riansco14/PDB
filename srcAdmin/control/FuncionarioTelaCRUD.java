package control;

import DAO.FuncionarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Funcionario;
import util.Dialogs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FuncionarioTelaCRUD implements Initializable{

    @FXML
    private TableView<Funcionario> tabela;

    @FXML
    private TableColumn<Funcionario, Integer> colCPF;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario, String> colPassaporte;

    @FXML
    private TableColumn<Funcionario, String> colEmail;


    @FXML
    private TextField fieldSearch;
    
    ObservableList<Funcionario> listItens = FXCollections
			.observableArrayList();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	colCPF.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>(
				"cpf"));
    	colNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>(
				"nome"));
    	colPassaporte.setCellValueFactory(new PropertyValueFactory<Funcionario, String>(
				"passaporte"));
    	colEmail.setCellValueFactory(new PropertyValueFactory<Funcionario, String>(
				"email"));
	}
    
    @FXML
    void actionDeletar(ActionEvent event) {
    	if(Dialogs.showConfirmation("Confirma��o", "Escolha uma op��o", "Deseja Excluir essa Passageiro ?")){
    		Long id=tabela.getSelectionModel().getSelectedItem().getCpf();
    		
    		if(new FuncionarioDAO().excluir(id))
    			Dialogs.showInformation("Transa��o realizada com sucesso", "Informa��o", "Livro Excluido com sucesso");
			else
				Dialogs.showError("Houve algum problema na Transa��o", "Error", "Seu Livro n�o foi excluido");

    	}
    }

    @FXML
    void actionSearch(ActionEvent event) {
		List<Funcionario> pessoas = null;
        FuncionarioDAO dao=new FuncionarioDAO();
		listItens.clear();
		
		if(fieldSearch.getText().length()==0){
			pessoas = dao.listar();
		}
		else{
			listItens.clear();
			
			//pessoas=dao.localizarPassageiros(fieldSearch.getText());
		}
		
		if (pessoas != null && pessoas.size() != 0) {

			for (Funcionario l : pessoas) {

				listItens.add(l);
			}
		}
		tabela.setItems(listItens);
    }
    /*
    public class PassageiroPropriety{
    	private SimpleLongProperty cpf;
    	private SimpleStringProperty nome;
    	private SimpleStringProperty passaporte;
    	private SimpleStringProperty email;
    	
    	
		public PassageiroPropriety(Passageiro pessoa) {
			super();
			this.cpf = new SimpleLongProperty(pessoa.getCpf());
			this.nome = new SimpleStringProperty(pessoa.getNome());
			this.passaporte = new SimpleStringProperty(pessoa.getPassaporte());
			this.email = new SimpleStringProperty(pessoa.getEmail());
		}

		
		public Long getCpf() {
			return cpf.get();
		}


		public void setCpf(Long id) {
			this.cpf.set(id);;
		}


		public String getNome() {
			return nome.get();
		}


		public void setNome(String nome) {
			this.nome.set(nome);
		}


    	
    	
    	
    	
    }
    */

}
