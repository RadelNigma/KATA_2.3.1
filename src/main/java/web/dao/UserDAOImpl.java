package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer,User> users = new HashMap<>();
//
//    static {
//        User user1 = new User(AUTO_ID.getAndIncrement(),"Radel","Nigma",42,"radenigma@mail.com");
//        User user2 = new User(AUTO_ID.getAndIncrement(),"Радель","Нигматуллин",42,"radig@mail.com");
//        User user3 = new User(AUTO_ID.getAndIncrement(),"Александр","Пушкин",37,"pushkin@mail.com");
//        users.put(user1.getId(),user1);
//        users.put(user2.getId(),user2);
//        users.put(user3.getId(),user3);
//    }

    @Override
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User ").list();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }


}
