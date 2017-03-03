package negocio;

import java.util.Date;

import DAO.BilheteDAO;
import model.Assento;
import model.Bilhete;
import model.Produto_Voo;

public class BilheteNegocio {
	public void criarBilhete(int valorTotal, Produto_Voo produto, Date validade, int numAssento) {
		Bilhete bilhete=new Bilhete();
		bilhete.setNumAssento(numAssento);
		bilhete.setProduto(produto);
		bilhete.setValidade(validade);
		bilhete.setValorTotal(valorTotal);
		
		BilheteDAO bilheteDAO=new BilheteDAO();
		bilheteDAO.inserir(bilhete);
		
		
		
		
		
	}
}
