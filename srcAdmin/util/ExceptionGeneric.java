package util;

public class ExceptionGeneric extends Exception {
    public final static String CPF_CADASTRADO = "Este CPF já está cadastrado";
    public final static String SENHA2_ERRADA = "A segunda senha informada está incorreta";
    public final static String CODIGO_EMAIL_INVALIDO = "O codigo inserido é invalido";
    public final static String PASSAGEIRO_N_EXISTE = "Este passageiro não existe";
    public final static String SENHA_INVALIDA = "Esta senha é invalida";
    public final static String EMPRESA_INVALIDA = "Esta empresa/companhia é invalida";
    public final static String TRIPULACAO_INVALIDA = "Esta tripulação é invalida";
    public final static String AERONAVE_INVALIDA = "Esta aeronave é invalida";
    public final static String AEROPORTO_INVALIDA = "Esta AEROPORTO é invalida";
    public final static String CAMPO_VAZIO = "Existe algum campo vazio";


    public ExceptionGeneric(String mensagem) {
        super(mensagem);
    }


}
