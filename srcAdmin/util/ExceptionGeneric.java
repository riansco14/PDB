package util;

public class ExceptionGeneric extends Exception {
    public final static String CPF_CADASTRADO = "Este CPF j� est� cadastrado";
    public final static String SENHA2_ERRADA = "A segunda senha informada est� incorreta";
    public final static String CODIGO_EMAIL_INVALIDO = "O codigo inserido � invalido";
    public final static String PASSAGEIRO_N_EXISTE = "Este passageiro n�o existe";
    public final static String SENHA_INVALIDA = "Esta senha � invalida";
    public final static String EMPRESA_INVALIDA = "Esta empresa/companhia � invalida";
    public final static String TRIPULACAO_INVALIDA = "Esta tripula��o � invalida";
    public final static String AERONAVE_INVALIDA = "Esta aeronave � invalida";
    public final static String AEROPORTO_INVALIDA = "Esta AEROPORTO � invalida";
    public final static String CAMPO_VAZIO = "Existe algum campo vazio";


    public ExceptionGeneric(String mensagem) {
        super(mensagem);
    }


}
