package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LivroCrudController {
/*
	@FXML
	TableView<LivroPropriety> tabela;

	@FXML
	TableColumn<LivroPropriety, String> colISBN;
	@FXML
	TableColumn<LivroPropriety, String> colTitulo;
	@FXML
	TableColumn<LivroPropriety, String> colAutor;
	@FXML
	TableColumn<LivroPropriety, String> colEditora;
	@FXML
	TableColumn<LivroPropriety, String> colCategoria;
	@FXML
	TextField fieldSearch;

	ObservableList<LivroPropriety> listItens = FXCollections
			.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colISBN.setCellValueFactory(new PropertyValueFactory<LivroPropriety, String>(
				"isbn"));
		colTitulo
				.setCellValueFactory(new PropertyValueFactory<LivroPropriety, String>(
						"titulo"));
		colAutor.setCellValueFactory(new PropertyValueFactory<LivroPropriety, String>(
				"autor"));
		colCategoria
				.setCellValueFactory(new PropertyValueFactory<LivroPropriety, String>(
						"categoria"));
		colEditora
				.setCellValueFactory(new PropertyValueFactory<LivroPropriety, String>(
						"editora"));

			
		
		tabela.setItems(listItens);

	}
	@FXML
	public void actionDeletar(ActionEvent event) {
//		if(Dialogs.showConfirmation("Confirma��o", "Escolha uma op��o", "Deseja Excluir esse Livro ?")){
//			String isbn=tabela.getSelectionModel().getSelectedItem().getIsbn();
		
			
		
	}
	
	@FXML
	public void actionSearch(ActionEvent event) {
//		List<Livro> livros = null; 
//		if(fieldSearch.getText().length()==0){
//			livros = negocio.selecionarTodosLivros();
//		}
//		else{
//			listItens.clear();
//			LivroDAO dao=new LivroDAO();
//			livros=dao.localizarTitle(fieldSearch.getText());
//		}
//		
//		if (livros != null && livros.size() != 0) {
//
//			for (Livro l : livros) {
//
//				listItens.add(new LivroPropriety(l));
//			}
//		}
		tabela.setItems(listItens);
		
		
	}



*/
}
