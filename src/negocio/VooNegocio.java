package negocio;

import DAO.AssentoDAO;
import DAO.ProdutoVooDAO;
import model.Assento;
import model.Bilhete;
import model.Voo;

import java.util.ArrayList;
import java.util.List;

public class VooNegocio {
	public boolean isAssentoOcupado(int idVoo,int numAssento){
		AssentoDAO assentoDAO=new AssentoDAO();
		
		if(assentoDAO.localizar(idVoo, numAssento).isEstado())
			return true;
		return false;
	}
	
	public List<Assento> mesclarPoltronas(int produtoID){
		ProdutoVooDAO prVooDAO=new ProdutoVooDAO();
		List<Voo> voos=prVooDAO.localizar(produtoID).getTrechos();

		List<Assento> assentosMesclado=voos.get(0).getAssentos();
		
		for (Voo voo : voos) {
			
			for (Assento assento : voo.getAssentos()) {
				for (Assento assentoT : assentosMesclado) {
					if(assento.getNumBilhete()!=null)
						assentoT=assento;
				}
			}
		}
		
		return assentosMesclado;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Assento> assentosMesclado=new ArrayList<>();
		ArrayList<Assento> assentosMesclado2=new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			Assento assento=new Assento();
			assentosMesclado.add(assento);
			
			Assento assento2=new Assento();
			assento2.setNumBilhete(new Bilhete());
			assentosMesclado2.add(assento2);
		}
		
		
		for (Assento assento : assentosMesclado) {
			for (Assento assentoT : assentosMesclado2) {
				if(assento.getNumBilhete()!=null)
					assentoT=assento;
			}
		}
		
		for (Assento assentoT : assentosMesclado) {
			System.out.println(assentoT!=null?"Ocupado":"Deso");
		}
		
		
		
		
	}
	
	
	
}
