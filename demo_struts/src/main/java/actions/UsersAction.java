package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsersAction extends ActionSupport implements ModelDriven<List<User>> {

    List<User> users;

    @Override
    public List<User> getModel(){
        return users;
    }

    @Override
    public String execute(){
        EntityManager em = Persistence.createEntityManagerFactory("struts_example_PU").createEntityManager();
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u", User.class);
        users = q.getResultList();
        em.close();
        return SUCCESS;
    }
}
