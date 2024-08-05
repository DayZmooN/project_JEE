package Dao;

import Entity.Categories;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategorieDao {

    private  SessionFactory factory;

    public CategorieDao() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Categories.class)
                .buildSessionFactory();
    }


    public void save(Categories entity) {
        try (Session session = factory.openSession()) {
            Transaction tx = null;
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {

        try{
            Session session = factory.openSession();
            Transaction tx = null;
            tx =session.beginTransaction();
            Categories category = session.get(Categories.class, id);
            session.delete(category);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
     }


    public List<Categories> getAllCategories() {
        List<Categories> categories = new ArrayList<>();
        try  {
            Session session = factory.openSession();
            Query<Categories> query = session.createQuery("FROM Categories", Categories.class);
            categories = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void updateCategorie(Categories categorie)
    {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(categorie);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur en updateCategorieServlet");
        }
    }

    public Categories getCategorie(long id) {
        Categories categorie = null;
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            categorie = session.get(Categories.class, id);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return categorie;
    }



}
