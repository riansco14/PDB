package DAO;

import model.Produto_Voo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class ProdutoVooDAO extends GenericDAO<Produto_Voo, Integer>{


    public static List<Produto_Voo> listarPVooPorAeroporto(String origem,String destino, Date data) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Produto_Voo.class);

        Date data2 = new Date(data.getYear(), data.getMonth(), data.getDate()+1);


        criteria.createAlias("origem", "AeroportoOAlias")
                .createAlias("destino", "AeroportoDestinoAlias")
                .add(Restrictions.ilike("AeroportoOAlias.nome","%"+origem+"%"))
                .add(Restrictions.ilike("AeroportoDestinoAlias.nome","%"+destino+"%"))
                .add(Restrictions.between("trechos.dataChegada",data,data2));



        List<Produto_Voo> voos = criteria.list();
        session.close();
        return voos;
    }

    public static List<Produto_Voo> listarPVooPorCidade(String origem,String destino, Date data) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Produto_Voo.class);

        Date data2 = new Date(data.getYear(), data.getMonth(), data.getDate()+1);


        criteria.createAlias("origem.endereco.municipio.nome","municipioOrigem")
                .add(Restrictions.ilike("municipioOrigem","%"+destino+"%"))
                .createAlias("destino.endereco.municipio.nome","municipioDestino")
                .add(Restrictions.ilike("municipioDestino","%"+destino+"%"))
                .add(Restrictions.between("trechos.dataChegada",data,data2));

        List<Produto_Voo> voos = criteria.list();
        session.close();
        return voos;
    }

}
