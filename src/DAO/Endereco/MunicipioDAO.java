package DAO.Endereco;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import DAO.GenericDAO;
import DAO.HibernateUtil;
import model.Endereco.Estado;
import model.Endereco.Municipio;

public class MunicipioDAO extends GenericDAO<Municipio, Long>{

	public List<Municipio> listarPorIdEstado(Long id) {
	        Session session = HibernateUtil.getSession();
	        session.beginTransaction();
	        Criteria criteria = session.createCriteria(Municipio.class);
	        criteria.createAlias("estado", "estadoAlias")
	                .add(Restrictions.eq("estadoAlias.id", id));
	        List<Municipio> estados = criteria.list();


	        session.close();
	        return estados;
	}

}
