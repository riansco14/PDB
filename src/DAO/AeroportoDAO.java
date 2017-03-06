package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Aeroporto;
import model.Empresa;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by RIAN on 28/12/2016.
 */
public class AeroportoDAO extends GenericDAO<Aeroporto> {


    public static ObservableList<Aeroporto> exibirAeroporto() {

        Session session=null;

        try {

            session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM Aeroporto order by nome");
            ObservableList<Aeroporto> list = FXCollections.observableArrayList(query.list());
            return  list;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        finally {
            session.close();
        }

    }
    public static ObservableList<Aeroporto> exibirTodasByNome(String nome) {

        Session session=null;

        try {

            session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM Aeroporto where nome like :nome order by nome");
            query.setString("nome", nome+"%");
            ObservableList<Aeroporto> list = FXCollections.observableArrayList(query.list());
            return  list;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        finally {
            session.close();
        }

    }



}
