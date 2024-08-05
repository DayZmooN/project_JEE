package Dao;

import Entity.Categories;
import Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class UserDAO {
    private SessionFactory factory;

    public UserDAO() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
    public void save(User user) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public List<User> findAll()
    {
        List<User> users = new ArrayList<>();
        try {
            Session session = factory.openSession();
            Query<User> query = session.createQuery("FROM User", User.class);
            users =query.list();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    public User findById(Long id) {
        User user = null;
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            user = session.get(User.class, id);
            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void delete(long id) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Delete failed");
        }
    }

    public void updateUser(User user) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Update failed");
        }
    }

    public User getUserByEmail(String email) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }


}
