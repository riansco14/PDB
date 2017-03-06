package DAO;

import model.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by RIAN on 28/12/2016.
 */
public class FuncionarioDAO extends GenericDAO<Funcionario,Long> {
    public List<Funcionario> localizarFuncionarios(String nome) {
        List<Funcionario> funcionarios = null;

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Funcionario.class);
        criteria.add(Restrictions.ilike("nome","%"+nome+"%"));

        funcionarios = criteria.list();
        session.close();

        return funcionarios;
    }
}
