package control;

import DAO.FuncionarioDAO;
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

public class TripulacaoTelaCRUD implements Initializable {

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

    @FXML
    private TextField fieldSearchFuncionario;

    ObservableList<Funcionario> listItensFuncionarios = FXCollections
            .observableArrayList();

    @FXML
    private TableView<Funcionario> tabela11;

    @FXML
    private TableColumn<Funcionario, Long> colCPF1;

    @FXML
    private TableColumn<Funcionario, String> colNome1;

    @FXML
    private TableColumn<Funcionario, String> colCargo1;

    ObservableList<Funcionario> listItensFuncionarios1 = FXCollections
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

        colCPF1.setCellValueFactory(new PropertyValueFactory<Funcionario, Long>(
                "cpf"));
        colNome1.setCellValueFactory(new PropertyValueFactory<Funcionario, String>(
                "nome"));
        colCargo1.setCellValueFactory(new PropertyValueFactory<Funcionario, String>(
                "cargo"));

    }

    @FXML
    void actionDeletar(ActionEvent event) {
        if (Dialogs.showConfirmation("Confirma��o", "Escolha uma op��o", "Deseja Excluir essa Passageiro ?")) {
            Integer id = tabela.getSelectionModel().getSelectedItem().getId();

            if (new TripulacaoDAO().excluir(id))
                Dialogs.showInformation("Transa��o realizada com sucesso", "Informa��o", "Livro Excluido com sucesso");
            else
                Dialogs.showError("Houve algum problema na Transa��o", "Error", "Seu Livro n�o foi excluido");

        }
    }

    @FXML
    void actionSearch(ActionEvent event) {
        List<Tripulacao> pessoas = null;
        TripulacaoDAO dao = new TripulacaoDAO();
        listItens.clear();

        if (fieldSearch.getText().length() == 0) {
            pessoas = dao.listar();
        } else {
            listItens.clear();
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
        Tripulacao tripulacao = tabela.getSelectionModel().getSelectedItem();
        if (tripulacao != null) {
            listItensFuncionarios.clear();
            List<Funcionario> funcionarios = tripulacao.getFuncionarios();
            listItensFuncionarios.addAll(funcionarios);
            tabela1.setItems(listItensFuncionarios);
        }


    }

    @FXML
    void actionSearchFuncionario(ActionEvent event) {
        List<Funcionario> funcionarios = null;
        FuncionarioDAO dao = new FuncionarioDAO();
        listItensFuncionarios1.clear();

        if (fieldSearchFuncionario.getText().length() == 0) {
            funcionarios = dao.listar();
        } else {
            funcionarios=dao.localizarFuncionarios(fieldSearchFuncionario.getText());
        }

        if (funcionarios != null && funcionarios.size() != 0) {

            for (Funcionario l : funcionarios) {

                listItensFuncionarios1.add(l);
            }
        }
        tabela11.setItems(listItensFuncionarios1);
    }

    @FXML
    void actionAddFuncionario(ActionEvent event) {
        Tripulacao tripulacao = tabela.getSelectionModel().getSelectedItem();
        Funcionario funcionario=tabela11.getSelectionModel().getSelectedItem();
        tripulacao.getFuncionarios().add(funcionario);
        listItensFuncionarios.add(funcionario);
        tabela1.setItems(listItensFuncionarios);
    }

    @FXML
    void actionRemoveFuncionario(ActionEvent event) {
        Funcionario funcionario=tabela1.getSelectionModel().getSelectedItem();
        listItensFuncionarios.remove(funcionario);
        tabela1.setItems(listItensFuncionarios);
    }

    @FXML
    void actionSalvarTripulacao(ActionEvent event) {
        Tripulacao tripulacao = tabela.getSelectionModel().getSelectedItem();
        TripulacaoDAO dao=new TripulacaoDAO();

        Tripulacao tripulacao2=dao.localizar(tripulacao.getId());
        tripulacao2.setFuncionarios(tripulacao.getFuncionarios());
        dao.update(tripulacao2);

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
