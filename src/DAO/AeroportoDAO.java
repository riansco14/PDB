package DAO;

import model.Aeroporto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by RIAN on 28/12/2016.
 */
public class AeroportoDAO extends GenericDAO<Aeroporto> {
    public Aeroporto localizarPorNome(String id) {
        Aeroporto obj=null;
        Session session=HibernateUtil.getSession();
        Criteria criteria =session.createCriteria(Aeroporto.class);
        criteria.add(Restrictions.ilike("nome","%"+id+"%"));

        obj=(Aeroporto)criteria.uniqueResult();
        return obj;
    }

    public Aeroporto localizarPorCidade(String id) {
        Aeroporto obj=null;
        Session session=HibernateUtil.getSession();
        Criteria criteria =session.createCriteria(Aeroporto.class);
       // criteria.add(Restrictions.ilike("nome","%"+id+"%"));

        obj=(Aeroporto)criteria.uniqueResult();
        return obj;
    }




}
