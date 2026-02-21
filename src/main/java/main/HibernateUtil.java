
package main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 public static final SessionFactory sessionFactory = buildSessionFactory();    
 private static SessionFactory buildSessionFactory(){
try{
return new Configuration().configure().buildSessionFactory();
}catch(HibernateException ex) {
            System.err.println("Falló la creación de SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
}
public static SessionFactory getSessionFactory(){
return sessionFactory;}
public static void shutdown(){
getSessionFactory().close();}

}

