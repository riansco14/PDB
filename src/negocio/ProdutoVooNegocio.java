package negocio;

import DAO.AeronaveDAO;
import DAO.AeroportoDAO;
import DAO.ProdutoVooDAO;
import DAO.VooDAO;
import model.Aeronave;
import model.Aeroporto;
import model.Produto_Voo;
import model.Voo;
import util.ExceptionGeneric;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RIAN on 06/03/2017.
 */
public class ProdutoVooNegocio {
    public void criarProdutoVooSemEscala(Double valorEconomico, Double valorExecutivo, Date dataPartida, Date dataChegada, Long idAeroDestino, Long idAeroOrigem, Integer idAeronave) throws ExceptionGeneric {
        Voo voo=new Voo();
        voo.setDataPartida(dataPartida);
        voo.setDataChegada(dataChegada);

        Aeroporto destino=new AeroportoDAO().localizar(idAeroDestino);
        if(destino==null) throw new ExceptionGeneric(ExceptionGeneric.AEROPORTO_INVALIDA);
        voo.setDestino(destino);
        Aeroporto origem=new AeroportoDAO().localizar(idAeroOrigem);
        if(origem==null) throw new ExceptionGeneric(ExceptionGeneric.AEROPORTO_INVALIDA);
        voo.setOrigem(origem);

        Aeronave aeronave=new AeronaveDAO().localizar(idAeronave);
        if(aeronave==null) throw new ExceptionGeneric(ExceptionGeneric.AERONAVE_INVALIDA);
        voo.setAeronave(aeronave);

        VooDAO vooDAO=new VooDAO();
        vooDAO.inserir(voo);

        voo=vooDAO.localizar(vooDAO.listar().size());

        Produto_Voo produtoVoo=new Produto_Voo();
        produtoVoo.setValorEconomico(valorEconomico);
        produtoVoo.setValorExecutivo(valorExecutivo);
        produtoVoo.setDestino(destino);
        produtoVoo.setOrigem(origem);

        List<Voo> voos=new ArrayList<Voo>();
        voos.add(voo);
        produtoVoo.setTrechos(voos);

        ProdutoVooDAO produtoVooDAO=new ProdutoVooDAO();
        produtoVooDAO.inserir(produtoVoo);


    }
}
