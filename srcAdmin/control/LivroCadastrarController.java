package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import util.Dialogs;
import util.ValidationField;

import java.net.URL;
import java.util.ResourceBundle;

public class LivroCadastrarController {
/*	@FXML TextField fieldISBN;
	@FXML TextField fieldTitle;
	@FXML TextField fieldAutor;
	@FXML TextField fieldEditora;
	@FXML TextField fieldCategoria;
	@FXML AnchorPane mainPane;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fieldISBN.addEventFilter(KeyEvent.ANY, ValidationField.getDigitEvent());
	}
	
	@FXML
	private void buttonInserir(ActionEvent event){
		for( Node node: mainPane.getChildren()) {

		    if( node instanceof TextField) {
		        System.out.println(node.getId());
		    }

		}
		boolean fieldIsEmpty=ValidationField.isEmptyAllFields(fieldISBN,fieldAutor,fieldCategoria,fieldEditora,fieldTitle);
		if(fieldIsEmpty) return;
		Livro     livro     = new Livro();
		Categoria categoria = new Categoria();
		Editora   editora   = new Editora();
		
		editora.setNome(fieldEditora.getText());
		categoria.setDescricao(fieldCategoria.getText());
		
		livro.setIsbn(fieldISBN.getText());
		livro.setAutor(fieldAutor.getText());
		livro.setTitulo(fieldTitle.getText());
		livro.setEditora(editora);
		livro.setCategoria(categoria);
		
		
		 if(new BibliotecaNegocio().inserirLivro(livro, editora))
			   Dialogs.showInformation("Transa��o realizada com sucesso", "Informa��o", "Livro inserido com sucesso");
		   else 
			   Dialogs.showError("Houve algum problema na Transa��o", "Error", "Seu Livro n�o foi inserido");
		
	}
*/
}
