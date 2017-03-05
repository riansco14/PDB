
package control;


public class GerenciadorTelaControllesr {
	/*
    @FXML     private StackPane workspace;
    @FXML     private Label lblAdmin;
    @FXML     private ListView<String> listViewLivro;
    @FXML     private ListView<String> listViewUsuario;
    @FXML     private ListView<String> listViewEmprestimo;
    @FXML     private final ObservableList<String> listLivro = FXCollections.observableArrayList("Adicionar Livro",
            "Manipular Livro","Manipular Exemplar");
    @FXML     private final ObservableList<String> listUsuario = FXCollections.observableArrayList("Adicionar Usuario",
            "Manipular Usuario");
    @FXML     private final ObservableList<String> listEmprestimo = FXCollections.observableArrayList("Retirar Livro",
            "Devolver Livro","Emprestimos por Usuario","Emprestimos por Livro");
    
    public static String textLabel;
    
    private Parent nodeAddLivro;
    private Parent nodeCRUDLivro;
    private Parent nodeCRUDUser;
    private Parent nodeAddUser;
    private Parent nodeEmprestimoUpdate;
    private Parent nodeEmprestimoAdicionar;
    private Parent nodeCRUDEstoque;
    
    public void setStageWorkspace (Node node) {
        workspace.getChildren().setAll(node);
    }
    
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblAdmin.setText(textLabel);
        
        listViewLivro.setItems(listLivro);
        listViewUsuario.setItems(listUsuario);
        listViewEmprestimo.setItems(listEmprestimo);
        
        try {
			nodeCRUDLivro=FXMLLoader.load(getClass().getResource(Location.TELA_LIVRO_CRUD.toString()));
			nodeAddLivro=FXMLLoader.load(getClass().getResource(Location.TELA_LIVRO_CADASTRAR.toString()));
			nodeCRUDEstoque=FXMLLoader.load(getClass().getResource(Location.TELA_ESTOQUE_CRUD.toString()));
			
			nodeAddUser=FXMLLoader.load(getClass().getResource(Location.TELA_USER_CADASTRAR.toString()));
			nodeCRUDUser=FXMLLoader.load(getClass().getResource(Location.TELA_USER_CRUD.toString()));
			
			nodeEmprestimoUpdate=FXMLLoader.load(getClass().getResource(Location.TELA_EMPRESTIMO_DEVOLVER.toString()));
			nodeEmprestimoAdicionar=FXMLLoader.load(getClass().getResource(Location.TELA_EMPRESTIMO_INSERIR.toString()));
       
        } catch (IOException e) {
			e.printStackTrace();
		}
        workspace.setOpacity(100);
    }
    
    
    @FXML 
    private void menuItemExit(ActionEvent event) {
    	Stage stage =(Stage) workspace.getScene().getWindow();
    	
    	if(Dialogs.showConfirmation("Confirma��o", "Deseja sair ? ", "Clique em OK se quiser sair"))
    		stage.close();
    }
    
    
    @FXML 
    private void clickListLivro(MouseEvent event) throws IOException{
        switch(listViewLivro.getSelectionModel().getSelectedIndex()){
            case 0:{
            	setStageWorkspace(nodeAddLivro);
            }
            break;

            case 1:{
            	setStageWorkspace(nodeCRUDLivro);
            }
            break;
            case 2:{
            	setStageWorkspace(nodeCRUDEstoque);
            }
            break;
        }    
        
    }
    
    @FXML 
    private void clickListUsuario(MouseEvent event) throws IOException{
        switch(listViewUsuario.getSelectionModel().getSelectedIndex()){
            case 0:{
            	setStageWorkspace(nodeAddUser);
            }
            break;

            case 1:{
            	setStageWorkspace(nodeCRUDUser);
            }
            break;
        }    
        
    }
    
    @FXML 
    private void clickListEmprestimo(MouseEvent event) throws IOException{
        switch(listViewEmprestimo.getSelectionModel().getSelectedIndex()){
            case 0:{
            	setStageWorkspace(nodeEmprestimoAdicionar);
            }
            break;
            
            case 1:{
            	setStageWorkspace(nodeEmprestimoUpdate);
            }
            break;
        }    
        
    }
    
    
    */
}
