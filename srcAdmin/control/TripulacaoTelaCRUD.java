package control;

import DAO.TripulacaoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Funcionario;
import model.Tripulacao;
import util.Dialogs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TripulacaoTelaCRUD implements Initializable{

    @FXML
    private TableView<Tripulacao> tabela;

    @FXML
    private TableColumn<Tripulacao, Integer> colID;

    @FXML
    private TableColumn<Tripulacao, String> colDescricao;

    @FXML
    private TableColumn<Tripulacao, String> colHorasVoo;

    @FXML
    private TextField fieldSearch;
    
    ObservableList<Tripulacao> listItens = FXCollections
			.observableArrayList();

    @FXML
    private TableView<Funcionario> tabela1;

    @FXML
    private TableColumn<Funcionario, Long> colCPF;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario, String> colCargo;

    ObservableList<Funcionario> listItensFuncionarios = FXCollections
            .observableArrayList();

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	colID.setCellValueFactory(new PropertyValueFactory<Tripulacao, Integer>(
				"id"));
    	colDescricao.setCellValueFactory(new PropertyValueFactory<Tripulacao, String>(
				"descricao"));
    	colHorasVoo.setCellValueFactory(new PropertyValueFactory<Tripulacao, String>(
				"horasVoo"));

        colCPF.setCellValueFactory(new PropertyValueFactory<Funcionario, Long>(
                "cpf"));
        colNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>(
                "nome"));
        colCargo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>(
                "cargo"));

	}
    
    @FXML
    void actionDeletar(ActionEvent event) {
    	if(Dialogs.showConfirmation("Confirma��o", "Escolha uma op��o", "Deseja Excluir essa Passageiro ?")){
    		Integer id=tabela.getSelectionModel().getSelectedItem().getId();
    		
    		if(new TripulacaoDAO().excluir(id))
    			Dialogs.showInformation("Transa��o realizada com sucesso", "Informa��o", "Livro Excluido com sucesso");
			else
				Dialogs.showError("Houve algum problema na Transa��o", "Error", "Seu Livro n�o foi excluido");

    	}
    }

    @FXML
    void actionSearch(ActionEvent event) {
		List<Tripulacao> pessoas = null;
        TripulacaoDAO dao=new TripulacaoDAO();
		listItens.clear();
		
		if(fieldSearch.getText().length()==0){
			pessoas = dao.listar();
		}
		else{
			listItens.clear();
			
			//pessoas=dao.localizarPassageiros(fieldSearch.getText());
		}
		
		if (pessoas != null && pessoas.size() != 0) {

			for (Tripulacao l : pessoas) {

				listItens.add(l);
			}
		}
		tabela.setItems(listItens);
    }

    @FXML
    void actionClicked(MouseEvent event) {
        Tripulacao tripulacao=tabela.getSelectionModel().getSelectedItem();
        if(tripulacao!=null){
            listItensFuncionarios.clear();
            List<Funcionario> funcionarios=tripulacao.getFuncionarios();
            listItensFuncionarios.addAll(funcionarios);
            tabela1.setItems(listItensFuncionarios);
        }


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
