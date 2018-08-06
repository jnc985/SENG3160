import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import entities.CompanyEntity;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static junit.framework.Assert.*;

public class CompanyEntityTest {

    private static EntityManager em = null;

    @BeforeClass
    public static void setUpClass() throws Exception {
        if (em == null) {
            em = (EntityManager) Persistence.createEntityManagerFactory("struts_example_PU").createEntityManager();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Start a transaction
        em.getTransaction().begin();
    }

    @After
    public void tearDown() throws Exception {
        em.getTransaction().commit();
    }

    @Test
    public void testAllOps(){


        // ------------  Create a Company C1 ---------
        CompanyEntity c1 = new CompanyEntity();
        c1.setCountry("Portugal");
        c1.setIncome(1000000.00);
        c1.setName("JBay");
        c1.setNumberEmployees(200);
        c1.setOwnerName("The Dude");
        c1.setPrivat(true);
        // At this Point the Entity does not have a
        // Persistent Identity and is not associated
        // with a persistent Context
        em.persist(c1); // Persist the Entity
        em.flush();
        // At this point the Entity has a Persistent
        // Identity and is associated witha Persistent
        // context.

        // ------------  Create a Company C2 ---------
        CompanyEntity c2 = new CompanyEntity();
        c2.setCountry("US");
        c2.setIncome(1000000000.00);
        c2.setName("Oracle");
        c2.setNumberEmployees(9000);
        c2.setOwnerName("Who?");
        c2.setPrivat(true);
        em.persist(c2);
        em.flush();

        System.out.println("Company 1 Id : " + c1.getIdcompany());
        System.out.println("Company 2 Id : " + c2.getIdcompany());

        // ------------  Perform Selects ---------
        Query query = em.createQuery("Select c from CompanyEntity c where c.idcompany=:companyid");
        query.setParameter("companyid", c1.getIdcompany());
        CompanyEntity retrieved1 = (CompanyEntity) query.getSingleResult();
        assertSame(c1, retrieved1);

        query.setParameter("companyid", c2.getIdcompany());
        CompanyEntity retrieved2 = (CompanyEntity) query.getSingleResult();
        assertSame(c2,retrieved2);

        assertNotSame(c1,c2);
        assertNotSame(retrieved1,retrieved2);

        // ------------  Update  ---------

        c2.setOwnerName("No One");
        c2.setPrivat(false);
        em.merge(c2);
        em.flush();

        System.out.println("Company 2 Id : " + c2.getIdcompany());
        System.out.println("Company 2 Name : " + c2.getName());
        System.out.println("Company 2 Owner : " + c2.getOwnerName());
        System.out.println("Company 2 Private : " + retrieved2.getPrivat());

        // ------------  Remove Entries  ---------
        em.remove(c1);
        em.remove(c2);
        // Both c1 c2 (and obviously retrieved1 and retrieved2) are removed,
        // which will happen upon commit of the Transaction


    }

    @Test
    public void testing(){
        // ------------  Create a Company C1 ---------
        CompanyEntity c1 = new CompanyEntity();
        c1.setCountry("Portugal");
        c1.setIncome(1000000.00);
        c1.setName("JBay");
        c1.setNumberEmployees(200);
        c1.setOwnerName("The Dude");
        c1.setPrivat(true);
        // At this Point the Entity does not have a
        // Persistent Identity and is not associated
        // with a persistent Context
        em.persist(c1); // Persist the Entity
        em.flush();
        // At this point the Entity has a Persistent
        // Identity and is associated witha Persistent
        // context.

        // ------------  Create a Company C2 ---------
        CompanyEntity c2 = new CompanyEntity();
        c2.setCountry("US");
        c2.setIncome(1000000000.00);
        c2.setName("Oracle");
        c2.setNumberEmployees(9000);
        c2.setOwnerName("Who?");
        c2.setPrivat(true);
        em.persist(c2);
        em.flush();

        // ------------  Perform Selects ---------
        TypedQuery<NameOwnerCompanyBean> myQuery = em.createQuery("SELECT NEW CompanyEntityTest$NameOwnerCompanyBean(c.income, c.ownerName) FROM CompanyEntity c WHERE c.idcompany=:someId", NameOwnerCompanyBean.class);
        myQuery.setParameter("someId", c1.getIdcompany());
        NameOwnerCompanyBean result = myQuery.getSingleResult();

        System.out.println(result.getIncome());
        System.out.println(result.getOwnerName());
    }


    static class NameOwnerCompanyBean{
        private String ownerName;
        private double income = 0.0;

        public NameOwnerCompanyBean(double income, String owner) {
            this.ownerName = owner;
            this.income = income;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }
    }
}
