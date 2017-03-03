package DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Assento;

public class AssentoDAO extends GenericDAO<Assento, Integer>{
	
	public Assento localizar(int idVoo, int numAssento) {
		Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Assento.class)
                .add(Restrictions.eq("voo.id",idVoo))
                .add(Restrictions.eq("numAssento",numAssento));

        
        session.close();
        return (Assento) criteria.uniqueResult();
    }
	
	
}
