package jcton.Entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class UserDao implements IUserDao{

    @Autowired
    private EntityManagerFactory emf;

    @Override
    public void addUser(User user) {
        //Add User
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public User getUser(int id){
        //get user with id
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class);
        q.setParameter("id", id);
        User res = q.getSingleResult();
        return res;
    }

    @Override
    public List<User> getAllUsers(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u", User.class);
        List<User> res = q.getResultList();

        return res;
    }
}
