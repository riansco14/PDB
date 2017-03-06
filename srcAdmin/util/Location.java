package util;

public enum Location {
    TELA_USER_CADASTRO("/view/userCadastro.fxml"),
    TELA_USER_LOGIN("/view/userLogin.fxml"),
    TELA_USER_MAIN("/view/userMainTela.fxml"),
	TELA_AERONAVE_CRUD("/view/AeronaveCRUD.fxml"),
    TELA_AERONAVE_INSERT("/view/AeronaveCreate.fxml"),
	TELA_PASSAGEIRO_CRUD("/view/PassageiroCRUD.fxml"),
	TELA_FUNCIONARIO_CRUD("/view/FuncionarioCRUD.fxml"),
    TELA_TRIPULACAO_CRUD("/view/TripulacaoCRUD.fxml"),
	TELA_GERENCIADORA("/view/GerenciadorTela.fxml"),
//	TELA_USER_CRUD("/view/userCRUD.fxml"),
//	TELA_USER_LOGIN("/view/userLogin.fxml"),
//	TELA_USER_CADASTRAR("/view/userCadastro.fxml"),
//	TELA_EMPRESTIMO_INSERIR("/view/emprestimoInsert.fxml"),
//	TELA_EMPRESTIMO_DEVOLVER("/view/emprestimoUpdate.fxml"),
//	TELA_ESTOQUE_CRUD("/view/exemplarModificar.fxml"),
	ESTILO_CSS("/style/style.css")
	
	;
	
	private String text;
	private Location(final String text){
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
}
