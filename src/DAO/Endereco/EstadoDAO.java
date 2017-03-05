package DAO.Endereco;

import DAO.GenericDAO;
import DAO.HibernateUtil;
import model.Endereco.Estado;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class EstadoDAO extends GenericDAO<Estado, Long> {
	public List<Estado> listarPorIdPais(Long id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Estado.class);
        criteria.createAlias("pais", "paisAlias")
                .add(Restrictions.eq("paisAlias.id", id));
        List<Estado> estados = criteria.list();


        session.close();
        return estados;
    }
}
