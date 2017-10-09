package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Conexao {

    private static final SessionFactory sessionFactory;
    public static final ThreadLocal thread = new ThreadLocal();

    static {
        try {
            AnnotationConfiguration configuration = new AnnotationConfiguration();
            configuration.addAnnotatedClass(entidades.building1.Building1Bean.class);
            configuration.addAnnotatedClass(entidades.building2.Building2Bean.class);
            configuration.addAnnotatedClass(entidades.building3.Building3Bean.class);
            configuration.addAnnotatedClass(entidades.building4.Building4Bean.class);
            configuration.addAnnotatedClass(entidades.building5.Building5Bean.class);
            configuration.addAnnotatedClass(entidades.activities.ActivityBean.class);
            configuration.addAnnotatedClass(entidades.appliance.ApplianceBean.class);
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        Session s = (Session) thread.get();
        if (s == null) {
            s = sessionFactory.openSession();
            thread.set(s);
        }
        return s;
    }

    public static void closeSession() {
        Session s = (Session) thread.get();
        if (s != null) {
            s.close();
        }
        s = null;
        thread.set(null);
    }

}
