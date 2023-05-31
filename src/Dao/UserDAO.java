package Dao;
import users.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    private static EntityManager conectar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db/usersTrivial.odb");
        return emf.createEntityManager();
    }

    public static void create(User user) {
        EntityManager em = conectar();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public static void delete(int id) {
        EntityManager em = conectar();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }

    public static List<User> readAll() {
        EntityManager em = conectar();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public static void update(User u) {
        EntityManager em = conectar();
        User us = em.find(User.class, u.getNombre());
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    public static User read() {
        EntityManager em = conectar();
        return null;
    }
}
