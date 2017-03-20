package DAO;

import model.Aeronave;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by RIAN on 28/12/2016.
 */
public class AeronaveDAO extends GenericDAO<Aeronave,Integer> {

	public List<Aeronave> localizarAeronaves(String nome) {
		List<Aeronave> aeronaves = null; 

		 	Session session = HibernateUtil.getSession();
	        session.beginTransaction();
	        Criteria criteria = session.createCriteria(Aeronave.class);
	        criteria.add(Restrictions.ilike("nome","%"+nome+"%"));

	        aeronaves = criteria.list();
	        session.close();
		
		return aeronaves;
	}
}
