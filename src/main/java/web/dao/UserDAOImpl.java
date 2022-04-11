package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImpl implements UserDAO{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer,User> users = new HashMap<>();

    static {
        User user1 = new User(AUTO_ID.getAndIncrement(),"Radel","Nigma",42,"radenigma@mail.com");
        User user2 = new User(AUTO_ID.getAndIncrement(),"Радель","Нигматуллин",42,"radig@mail.com");
        User user3 = new User(AUTO_ID.getAndIncrement(),"Александр","Пушкин",37,"pushkin@mail.com");
        users.put(user1.getId(),user1);
        users.put(user2.getId(),user2);
        users.put(user3.getId(),user3);
    }

    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(),user);
    }

    @Override
    public void delete(User user) {
      users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(),user);
    }

    @Override
    public User getById(int id) {
      return users.get(id);
    }


}
