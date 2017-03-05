package DAO;

import model.Voo;

/**
 * Created by RIAN on 28/12/2016.
 */
public class VooDAO extends GenericDAO<Voo,Integer> {
    /*
    public static List<Voo> listarPorCidadeOrigem(String cidadeOrigem) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Voo.class);
        criteria.createAlias("rota", "rotaAlias")
                .createAlias("rota.origem", "aeroportoAlias")
                .createAlias("aeroportoAlias.endereco", "enderecoAlias")
                .add(Restrictions.ilike("enderecoAlias.", "%" + cidadeOrigem + "%"));
        List<Voo> voos = criteria.list();


        session.close();
        return voos;
    }

    public static List<Voo> listarVoosCompleto(Date data) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Voo.class);

        Date data2 = new Date(data.getYear(), data.getMonth(), data.getDate());
        data2.setHours(23);
        data2.setMinutes(59);

        criteria.createAlias("rota", "rotaAlias")
                // .add(Restrictions.eq("rotaAlias.id",rota.getId()))
                .add(Restrictions.between("dataPartida", data, data2));
        List<Voo> voos = criteria.list();
        session.close();
        return voos;
    }
        */



}




























