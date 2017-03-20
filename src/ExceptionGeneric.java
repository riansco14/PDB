
public class ExceptionGeneric extends Exception{
	

	public final static String ASSENTO_OCUPADO="ASSENTO OCUPADO";
	
	private String mensagem;

	public ExceptionGeneric(String mensagem) {
		super(mensagem);
	}
	
	
}
