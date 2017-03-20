package control;

import DAO.AeronaveDAO;
import javafx.beans.property.SimpleIntegerProperty;
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
import model.Aeronave;
import util.Dialogs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AeronaveTelaCRUD implements Initializable{

    @FXML
    private TableView<AeronavePropriety> tabela;

    @FXML
    private TableColumn<AeronavePropriety, Integer> colID;

    @FXML
    private TableColumn<AeronavePropriety, String> colNome;

    @FXML
    private TableColumn<AeronavePropriety, Integer> colEconoAssentos;

    @FXML
    private TableColumn<AeronavePropriety, Integer> colExeAssentos;

    @FXML
    private TableColumn<AeronavePropriety, Integer> colTotalAssentos;

    @FXML
    private TextField fieldSearch;
    
    ObservableList<AeronavePropriety> listItens = FXCollections
			.observableArrayList();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	colID.setCellValueFactory(new PropertyValueFactory<AeronavePropriety, Integer>(
				"id"));
    	colNome.setCellValueFactory(new PropertyValueFactory<AeronavePropriety, String>(
				"nome"));
    	colEconoAssentos.setCellValueFactory(new PropertyValueFactory<AeronavePropriety, Integer>(
				"numAssentosEco"));
    	colExeAssentos.setCellValueFactory(new PropertyValueFactory<AeronavePropriety, Integer>(
				"numAssentosExe"));
    	colTotalAssentos.setCellValueFactory(new PropertyValueFactory<AeronavePropriety, Integer>(
				"numAssentosTotal"));
	}
    
    @FXML
    void actionDeletar(ActionEvent event) {
    	if(Dialogs.showConfirmation("Confirma��o", "Escolha uma op��o", "Deseja Excluir essa Aeronave ?")){
    		int id=tabela.getSelectionModel().getSelectedItem().getId();
    		
    		if(new AeronaveDAO().excluir(id))
    			Dialogs.showInformation("Transa��o realizada com sucesso", "Informa��o", "Livro Excluido com sucesso");
			else
				Dialogs.showError("Houve algum problema na Transa��o", "Error", "Seu Livro n�o foi excluido");

    	}
    }

    @FXML
    void actionSearch(ActionEvent event) {
		List<Aeronave> aeronaves = null; 
		AeronaveDAO dao=new AeronaveDAO();
		listItens.clear();
		
		if(fieldSearch.getText().length()==0){
			aeronaves = dao.listar();
		}
		else{
			listItens.clear();
			
			aeronaves=dao.localizarAeronaves(fieldSearch.getText());
		}
		
		if (aeronaves != null && aeronaves.size() != 0) {

			for (Aeronave l : aeronaves) {

				listItens.add(new AeronavePropriety(l));
			}
		}
		tabela.setItems(listItens);
    }
    
    public class AeronavePropriety{
    	private SimpleIntegerProperty id;
    	private SimpleStringProperty nome;
    	private SimpleIntegerProperty numAssentosTotal;
    	private SimpleIntegerProperty numAssentosEco;
    	private SimpleIntegerProperty numAssentosExe;
    	
    	
		public AeronavePropriety(Aeronave aeronave) {
			super();
			this.id = new SimpleIntegerProperty(aeronave.getId());
			this.nome = new SimpleStringProperty(aeronave.getNome());
			this.numAssentosTotal = new SimpleIntegerProperty(aeronave.getNumAssentosTotal());
			this.numAssentosEco = new SimpleIntegerProperty(aeronave.getNumAssentosEco());
			this.numAssentosExe = new SimpleIntegerProperty(aeronave.getNumAssentosExe());
		}

		
		public Integer getId() {
			return id.get();
		}


		public void setId(Integer id) {
			this.id.set(id);;
		}


		public String getNome() {
			return nome.get();
		}


		public void setNome(String nome) {
			this.nome.set(nome);
		}


		public Integer getNumAssentosTotal() {
			return numAssentosTotal.get();
		}


		public void setNumAssentosTotal(Integer numAssentosTotal) {
			this.numAssentosTotal.set(numAssentosTotal);
		}


		public Integer getNumAssentosEco() {
			return numAssentosEco.get();
		}


		public void setNumAssentosEco(Integer numAssentosEco) {
			this.numAssentosEco.set(numAssentosEco);;
		}


		public Integer getNumAssentosExe() {
			return numAssentosExe.get();
		}


		public void setNumAssentosExe(Integer numAssentosExe) {
			this.numAssentosExe.set(numAssentosExe);;
		}
		
    	
    	
    	
    	
    }

	

}
