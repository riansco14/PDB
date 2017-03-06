package control;

import DAO.AeroportoDAO;
import DAO.EmpresaDAO;
import Utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Aeroporto;
import model.Empresa;
import model.Endereco;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Doda on 27/02/2017.
 */
public class CadAeroportoController implements Initializable {

    @FXML
    private Text meuLabel;

    @FXML
    public TextField nomeAeroporto,descricaoAeroporto;

    @FXML
    private Button salvarButton;

    @FXML
    private Button voltarButton;


    @FXML
    private TextField enderecoText,numeroText,complementoText,bairroText,cepText,cidadeText,paisText,nomeEmpresaText;
    @FXML
    private ComboBox<String> ufCombo;
    @FXML
    private Button selecionarCidadesButton,selecionarEmpresasButton;


    private String acao;
    private Integer idEmpresa;
    private int idEndereco;

    private Long idAeroporto;


    public void limparCampos(){
        this.nomeAeroporto.clear();
        this.nomeAeroporto.requestFocus();
    }

    @FXML
    public void salvarCadastro(){

        if (!nomeAeroporto.getText().isEmpty()){

            if (this.acao==""){


                Endereco meuEndereco = new Endereco(this.enderecoText.getText(), this.paisText.getText(), this.ufCombo.getSelectionModel().getSelectedItem(),
                        this.cidadeText.getText().toUpperCase(), this.bairroText.getText().toUpperCase(), Integer.valueOf(this.getNumeroText().getText()));


                new AeroportoDAO().inserir(new Aeroporto(meuEndereco,
                        this.nomeAeroporto.getText(),
                        this.descricaoAeroporto.getText().toUpperCase(),
                        new EmpresaDAO().localizar(idEmpresa)));

                Utils.mensagem("Mensagem para Você.","Castrastro realizada com sucesso !");
                limparCampos();

            }
            else
            {

                Endereco meuEndereco = new Endereco(this.idEndereco,this.enderecoText.getText(), this.paisText.getText(), this.ufCombo.getSelectionModel().getSelectedItem(),
                        this.cidadeText.getText().toUpperCase(), this.bairroText.getText().toUpperCase(), Integer.valueOf(this.getNumeroText().getText()));

                Aeroporto update = new Aeroporto(this.idAeroporto,meuEndereco,
                        this.nomeAeroporto.getText(),
                        this.descricaoAeroporto.getText().toUpperCase(),
                        new EmpresaDAO().localizar(idEmpresa));

                new AeroportoDAO().update(update);

                Utils.mensagem("Mensagem para Você.","alteração realizada com sucesso !");
                voltarTela();
            }


        }
        else{
            Utils.mensagemError("Mensagem pra você.", "É preciso preencher o nome da empresa !");
        }

    }


    @FXML
    public void voltarTela(){
        Stage stage = (Stage)voltarButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ufCombo.setPromptText("Selecione");
        ufCombo.getItems().addAll("", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO");

        this.nomeAeroporto.textProperty().addListener((ov, oldValue, newValue) ->{
            this.nomeAeroporto.setText(newValue.toUpperCase());
        } );

    }

//    public void exibirDadosEmpresa(){
//        List<Empresa> dados = new EmpresaDAO().listar();
//
//        for (Empresa empresa : dados) {
//            this.empresaCombo.getItems().add(empresa.getNome());
//        }
//
//    }

    public TextField getNomeAeroporto() {
        return nomeAeroporto;
    }

    public Text getMeuLabel(){
        return this.meuLabel;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }


    public Button getSalvarButton() {
        return salvarButton;
    }

    public Button getVoltarButton() {
        return voltarButton;
    }

    public TextField getEnderecoText() {
        return enderecoText;
    }

    public TextField getNumeroText() {
        return numeroText;
    }

    public TextField getComplementoText() {
        return complementoText;
    }

    public TextField getBairroText() {
        return bairroText;
    }

    public TextField getCepText() {
        return cepText;
    }

    public TextField getCidadeText() {
        return cidadeText;
    }

    public TextField getPaisText() {
        return paisText;
    }

    public ComboBox<String> getUfCombo() {
        return ufCombo;
    }

    public Button getSelecionarCidadesButton() {
        return selecionarCidadesButton;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public void setMeuLabel(Text meuLabel) {
        this.meuLabel = meuLabel;
    }

    public void setNomeAeroporto(TextField nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public void setSalvarButton(Button salvarButton) {
        this.salvarButton = salvarButton;
    }

    public void setVoltarButton(Button voltarButton) {
        this.voltarButton = voltarButton;
    }

    public void setEnderecoText(TextField enderecoText) {
        this.enderecoText = enderecoText;
    }

    public void setNumeroText(TextField numeroText) {
        this.numeroText = numeroText;
    }

    public void setComplementoText(TextField complementoText) {
        this.complementoText = complementoText;
    }

    public void setBairroText(TextField bairroText) {
        this.bairroText = bairroText;
    }

    public void setCepText(TextField cepText) {
        this.cepText = cepText;
    }

    public void setCidadeText(TextField cidadeText) {
        this.cidadeText = cidadeText;
    }

    public void setPaisText(TextField paisText) {
        this.paisText = paisText;
    }

    public void setUfCombo(ComboBox<String> ufCombo) {
        this.ufCombo = ufCombo;
    }

    public void setSelecionarCidadesButton(Button selecionarCidadesButton) {
        this.selecionarCidadesButton = selecionarCidadesButton;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TextField getDescricaoAeroporto() {
        return descricaoAeroporto;
    }

    public Long getIdAeroporto() {
        return idAeroporto;
    }

    public void setIdAeroporto(Long idAeroporto) {
        this.idAeroporto = idAeroporto;
    }

    @FXML
    public void selecionarEmpresas() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LocalizarEmpresas.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Localizando empresas");
        LocalizarEmpresasController localizarEmpresas = (LocalizarEmpresasController) loader.getController();
        stage.setScene(new Scene(root));
        stage.showAndWait();

        if (localizarEmpresas.retorno) {
            setIdEmpresa(localizarEmpresas.getIdEmpresaRetorno());
            this.nomeEmpresaText.setText(localizarEmpresas.getNomeEmpresaRetorno());
        }
    }

}
