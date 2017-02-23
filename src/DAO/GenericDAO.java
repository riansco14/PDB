package DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO <T> {
    private Class<T> classe;

    public GenericDAO(){

        Class<?> thisClass = getClass();
        ParameterizedType t = (ParameterizedType) thisClass.getGenericSuperclass();
        Type t2 = t.getActualTypeArguments()[0];
        this.classe = (Class<T>) t2;
    }

    public T localizar(int id) {
        T obj=null;
        Session session=HibernateUtil.getSession();
        //session.beginTransaction();
        obj=(T)session.get(classe,id);
      //  session.close();
        return obj;
    }

    @SuppressWarnings("unchecked")
    public List<T> listar() {
        List<T> list=new ArrayList<T>();
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria=session.createCriteria(classe);
        list=criteria.list();
        session.close();
        return list;
    }

    public boolean inserir(T obj) {
        boolean result=false;
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();

        try {
            session.persist(obj);
            tx.commit();
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
            if(tx.isActive()) tx.rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean excluir(long id) {
        boolean result=false;
        Session session=HibernateUtil.getSession();
        Transaction tx=session.getTransaction();

        try {
            tx.begin();
            Object obj=session.load(classe,id);
            session.delete(obj);
            tx.commit();
            result=true;
        } catch (Exception e) {
            if(tx.isActive()) tx.rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean update(T obj) {
        boolean result=false;
        Session session=HibernateUtil.getSession();
        Transaction tx=session.getTransaction();

        try {
            tx.begin();
            session.update(obj);
            tx.commit();
            result=true;
        } catch (Exception e) {
            if(tx.isActive()) tx.rollback();
        } finally {
            session.close();
        }
        return result;
    }
}
