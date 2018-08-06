package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entities.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Override
    public User getModel(){
        return user;
    }

    @Override
    public String execute() throws Exception{
        return SUCCESS;
    }

    public String newUser(){
        //Add to Database
        EntityManager em = Persistence.createEntityManagerFactory("struts_example_PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return SUCCESS;
    }
}
