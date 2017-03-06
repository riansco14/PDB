package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Empresa;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doda on 27/02/2017.
 */
public class EmpresaDAO extends GenericDAO<Empresa> {

    public static ObservableList<Empresa> exibirEmpresas() {

        Session session=null;

        try {

            session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM Empresa order by nome");
            ObservableList<Empresa> list = FXCollections.observableArrayList(query.list());
            return  list;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        finally {
            session.close();
        }

    }
    public static ObservableList<Empresa> exibirTodasByNome(String nome) {

        Session session=null;

        try {

            session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM Empresa where nome like :nome order by nome");
            query.setString("nome", nome+"%");
            ObservableList<Empresa> list = FXCollections.observableArrayList(query.list());
            return  list;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        finally {
            session.close();
        }

    }




    public static void DeletePorNome(String nome) {

        Transaction tx = null;
        Session session=null;

        try {

            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("delete Empresa where nome=:nome");
            query.setString("nome", nome);
            tx.commit();//faz a transacao
            int iRetorno = query.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            session.close();
        }

    }


    public static void DeletePorId(Integer id) {

        Transaction tx = null;
        Session session=null;

        try {

            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("delete Empresa where id=:id");
            query.setInteger("id", id);
            tx.commit();//faz a transacao
            int iRetorno = query.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            session.close();
        }

    }






}
