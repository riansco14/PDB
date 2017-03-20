package control;

import DAO.PassageiroDAO;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Passageiro;
import util.Dialogs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PassageiroTelaCRUD implements Initializable{

    @FXML
    private TableView<PassageiroPropriety> tabela;

    @FXML
    private TableColumn<PassageiroPropriety, Integer> colCPF;

    @FXML
    private TableColumn<PassageiroPropriety, String> colNome;

    @FXML
    private TableColumn<PassageiroPropriety, String> colPassaporte;

    @FXML
    private TableColumn<PassageiroPropriety, String> colEmail;


    @FXML
    private TextField fieldSearch;
    
    ObservableList<PassageiroPropriety> listItens = FXCollections
			.observableArrayList();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	colCPF.setCellValueFactory(new PropertyValueFactory<PassageiroPropriety, Integer>(
				"cpf"));
    	colNome.setCellValueFactory(new PropertyValueFactory<PassageiroPropriety, String>(
				"nome"));
    	colPassaporte.setCellValueFactory(new PropertyValueFactory<PassageiroPropriety, String>(
				"passaporte"));
    	colEmail.setCellValueFactory(new PropertyValueFactory<PassageiroPropriety, String>(
				"email"));
	}
    
    @FXML
    void actionDeletar(ActionEvent event) {
    	if(Dialogs.showConfirmation("Confirmação", "Escolha uma op��o", "Deseja Excluir essa Passageiro ?")){
    		Long id=tabela.getSelectionModel().getSelectedItem().getCpf();
    		
    		if(new PassageiroDAO().excluir(id))
    			Dialogs.showInformation("Transa��o realizada com sucesso", "Informa��o", "Livro Excluido com sucesso");
			else
				Dialogs.showError("Houve algum problema na Transa��o", "Error", "Seu Livro n�o foi excluido");

    	}
    }

    @FXML
    void actionSearch(ActionEvent event) {
		List<Passageiro> pessoas = null; 
		PassageiroDAO dao=new PassageiroDAO();
		listItens.clear();
		
		if(fieldSearch.getText().length()==0){
			pessoas = dao.listar();
		}
		else{
			listItens.clear();
			
			pessoas=dao.localizarPassageiros(fieldSearch.getText());
		}
		
		if (pessoas != null && pessoas.size() != 0) {

			for (Passageiro l : pessoas) {

				listItens.add(new PassageiroPropriety(l));
			}
		}
		tabela.setItems(listItens);
    }
    
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

}
