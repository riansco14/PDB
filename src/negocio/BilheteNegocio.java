package negocio;

import DAO.AssentoDAO;
import DAO.BilheteDAO;
import DAO.ProdutoVooDAO;
import model.Assento;
import model.Bilhete;
import model.Produto_Voo;
import model.Voo;

import java.util.Date;

public class BilheteNegocio {
	public void criarBilhete(int valorTotal, Integer idProduto, Date validade, int numAssento) {
		Bilhete bilhete=new Bilhete();

		Produto_Voo produto=new ProdutoVooDAO().localizar(idProduto);
		bilhete.setProduto(produto);
		bilhete.setValidade(validade);
		bilhete.setValorTotal(valorTotal);
		bilhete.setNumAssento(numAssento);

		BilheteDAO bilheteDAO=new BilheteDAO();
		bilheteDAO.inserir(bilhete);

		Assento assento1=new Assento();
		assento1.setNumBilhete(bilhete);
		AssentoDAO assentoDAO=new AssentoDAO();
		for (Voo voo:produto.getTrechos()) {
			Assento assento = assentoDAO.localizar(voo.getId(), numAssento);
			assento.setNumBilhete(assento1.getNumBilhete());
			assentoDAO.update(assento);
		}

		//	assentoDAO.update(assento);
//		}
		System.out.println();





	}
}
