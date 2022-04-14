package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserDAOImp implements UserDAO {
//    private final LocalContainerEntityManagerFactoryBean entityManager;
//
//    public UserDAOImp(LocalContainerEntityManagerFactoryBean entityManager) {
//        this.entityManager = entityManager;
//    }
    @PersistenceContext
    @Qualifier("persistenceJPAConfig")
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {

        return entityManager.createQuery("from User ").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }
}
