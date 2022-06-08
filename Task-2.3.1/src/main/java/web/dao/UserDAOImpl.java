package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<User> allUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void add(User user) {
        em.persist(user);
    }
    @Transactional
    @Override
    public void update(User user) {
        em.merge(user);
    }
    @Transactional
    @Override
    public void delete(long id) {
        em.remove(getUserById(id));
    }
    @Transactional
    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }
}
