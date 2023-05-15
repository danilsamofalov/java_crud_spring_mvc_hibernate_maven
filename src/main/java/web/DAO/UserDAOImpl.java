package web.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import web.entity.User;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private EntityManager entityManager;


    protected EntityManager getEntityManager() {
        return this.entityManager;
    }


    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("FROM User ORDER BY 1", User.class)
                .getResultList();

    }

    @Override
    public void createUser(User user) {

        getEntityManager().persist(user);
    }

    @Override
    public void updateUser(User user) {
        getEntityManager().merge(user);
    }

    @Override
    public void removeUser(int id) {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User findById(int id) {
        return getEntityManager().find(User.class, id);
    }
}
