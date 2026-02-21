
package main;

import view.Login;

public class E_comerceProyect {

    public static void main(String[] args) {
       HibernateUtil.sessionFactory.openSession();
        Login login = new Login();
        login.setVisible(true);
        
}
    }

