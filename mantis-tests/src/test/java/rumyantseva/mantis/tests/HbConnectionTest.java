/*package rumyantseva.mantis.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rumyantseva.mantis.model.UserData;
import rumyantseva.mantis.model.Users;

import java.util.List;

public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

  @Test(enabled = false)
  public void testHbConnection() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Users> result = session.createQuery("from mantis_user_table where username != administrator").list();

    session.getTransaction().commit();
    session.close();

    //for (UserData user : result) {
    //  System.out.println(user);
    //  System.out.println(user.getEmail());
    //}

  }

}

 */