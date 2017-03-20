package negocio;

import DAO.AeronaveDAO;
import DAO.EmpresaDAO;
import DAO.TripulacaoDAO;
import model.Aeronave;
import model.Empresa;
import model.Tripulacao;
import util.ExceptionGeneric;

/**
 * Created by RIAN on 05/03/2017.
 */
public class AeronaveNegocio {
    public void criarAeronave(String nome, int NumAssentosEco, int NumAssentosExe, int NumAssentosTotal, int idCompanhia, int idTripulacao) throws ExceptionGeneric {
        Aeronave aeronave=new Aeronave();
        aeronave.setNome(nome);
        aeronave.setNumAssentosEco(NumAssentosEco);
        aeronave.setNumAssentosExe(NumAssentosExe);
        aeronave.setNumAssentosTotal(NumAssentosTotal);
        Empresa empresa=new EmpresaDAO().localizar(idCompanhia);
        Tripulacao tripulacao=new TripulacaoDAO().localizar(idTripulacao);

        if (empresa==null) throw new ExceptionGeneric(ExceptionGeneric.EMPRESA_INVALIDA);
            aeronave.setCompanhia(empresa);
        if (tripulacao==null)throw new ExceptionGeneric(ExceptionGeneric.TRIPULACAO_INVALIDA);
            aeronave.setTripulacao(tripulacao);

        AeronaveDAO dao=new AeronaveDAO();
        dao.inserir(aeronave);
    }
}
