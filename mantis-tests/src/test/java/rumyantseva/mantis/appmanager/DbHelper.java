/*package rumyantseva.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import rumyantseva.mantis.model.UserData;
import rumyantseva.mantis.model.Users;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(ApplicationManager app) {

    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Users users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from mantis_user_table where username != administrator").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }

}


 */


