package negocio;

import DAO.AssentoDAO;

public class VooNegocio {
	public boolean isAssentoOcupado(int idVoo,int numAssento){
		AssentoDAO assentoDAO=new AssentoDAO();
		
		if(assentoDAO.localizar(idVoo, numAssento).isEstado())
			return true;
		return false;
	}
	

	
	
	
}
