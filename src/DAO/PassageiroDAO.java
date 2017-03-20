package DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Aeronave;
import model.Passageiro;

public class PassageiroDAO extends GenericDAO<Passageiro, Long>{

	public List<Passageiro> localizarPassageiros(String nome) {
		List<Passageiro> passageiros = null; 

	 	Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Passageiro.class);
        criteria.add(Restrictions.ilike("nome","%"+nome+"%"));

        passageiros = criteria.list();
        session.close();
	
	return passageiros;
	}

}
