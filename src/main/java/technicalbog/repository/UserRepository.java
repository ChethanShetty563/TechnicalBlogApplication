package technicalbog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import technicalbog.model.User;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(name="techblog")
    private EntityManagerFactory emf;

    public void registerUser(User newUser) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(newUser);
            et.commit();
        }
        catch (Exception e) {
            et.rollback();
        }

    }
    public User checkUser(String username,String password) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u WHERE u.Username = :username AND u.Password = :password ", User.class);
            typedQuery.setParameter("username", username);
            typedQuery.setParameter("password", password);

            return typedQuery.getSingleResult();

        }
        catch (NoResultException r) {
            return null;
        }

    }


}
