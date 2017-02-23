package DAO;

import model.Voo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * Created by RIAN on 28/12/2016.
 */
public class VooDAO extends GenericDAO<Voo>{
    public static List<Voo> listarPorCidadeOrigem(String cidadeOrigem) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria =session.createCriteria(Voo.class);
        criteria.createAlias("rota","rotaAlias")
                .createAlias("rota.origem","aeroportoAlias")
                .createAlias("aeroportoAlias.endereco","enderecoAlias")
                .add(Restrictions.ilike("enderecoAlias.cidade","%"+cidadeOrigem+"%"));
        List<Voo> voos=criteria.list();


        session.close();
        return  voos;
    }
    public static List<Voo> listarVoosCompleto(Date data){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria =session.createCriteria(Voo.class);

        Date data2=new Date(data.getYear(),data.getMonth(),data.getDate());
        data2.setHours(23);
        data2.setMinutes(59);

        criteria.createAlias("rota","rotaAlias")
               // .add(Restrictions.eq("rotaAlias.id",rota.getId()))
                .add(Restrictions.between("dataPartida",data,data2));
        List<Voo> voos=criteria.list();
        session.close();
        return  voos;
    }

    public static List<Voo> listarVoosCompleto2(Date data){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria =session.createCriteria(Voo.class);


        criteria.createAlias("origem", "aeroportoOrigemAlias")
                .createAlias("aeroportoAlias.endereco", "enderecoOrigemAlias")

        List<Voo> voos=criteria.list();
        session.close();
        return  voos;
    }






























}
