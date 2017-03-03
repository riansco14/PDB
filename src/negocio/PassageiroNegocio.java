package negocio;

import DAO.PassageiroDAO;
import model.Passageiro;

/**
 * Created by RIAN on 26/02/2017.
 */
public class PassageiroNegocio {
	public boolean isExiste(Long CPF) {
		PassageiroDAO passageiroDAO=new PassageiroDAO();
		if(passageiroDAO.localizar(CPF) != null)
			return false;
		return true;
	}
	
	
	
	

}
