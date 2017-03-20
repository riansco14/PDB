package DAO;

import model.Assento;
import model.Produto_Voo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;

public class AssentoDAO extends GenericDAO<Assento, Integer>{
	
	public Assento localizar(int idVoo, int numAssento) {
		Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Assento.class)
                .add(Restrictions.eq("voo.id",idVoo))
                .add(Restrictions.eq("numAssento",numAssento));

        
        return (Assento) criteria.uniqueResult();
    }

    public boolean update2(Integer idAssento, Integer idBilhete) {
        boolean result=false;
        Session session=HibernateUtil.getSession();
        Transaction tx=session.getTransaction();

        try {
            tx.begin();
            Assento assento= (Assento) session.get(Assento.class,idAssento);
            session.merge(assento);
            tx.commit();
            result=true;
        } catch (Exception e) {
            if(tx.isActive()) tx.rollback();
        } finally {
//            session.close();
        }
        return result;
    }


    public List<Assento> listarAssentosVagosPorIdProduto(Integer idPVoo) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Produto_Voo produtoVoo=new ProdutoVooDAO().localizar(idPVoo);

        Criteria criteria = session.createCriteria(Assento.class);
                criteria.setProjection(Projections.projectionList()
                .add(Projections.distinct(Projections.projectionList()
                        .add(Projections.property("numAssento"), "numAssento")
                        .add(Projections.property("id"), "id"))));
        criteria.add(Restrictions.in("voo",produtoVoo.getTrechos()))
                .add(Restrictions.isNotNull("numBilhete"));
        criteria.addOrder(Order.desc("numAssento"));

        criteria.setResultTransformer(Transformers.aliasToBean(Assento.class));
        List<Integer> integers=new ArrayList<Integer>();
        for(Assento a:(List<Assento>)criteria.list())
            integers.add(a.getNumAssento());


        Criteria criteria2 = session.createCriteria(Assento.class);
        criteria2.setProjection(Projections.projectionList()
                .add(Projections.distinct(Projections.projectionList()
                                .add(Projections.property("numAssento"), "numAssento")
                        .add(Projections.property("classe"),"classe"))));

        criteria2.add(Restrictions.not(Restrictions.in("numAssento",integers)));
        criteria2.addOrder(Order.desc("numAssento"));
        criteria2.setResultTransformer(Transformers.aliasToBean(Assento.class));
        return criteria2.list();
    }
	
}
