
package persistence;

import java.util.List;
import main.HibernateUtil;
import main.PaswordHasher;
import main.SessionUsuario;
import model.Empleado;
import model.LoginResult;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpleadoRepository {
LoginResult loginResult = new LoginResult();
    public EmpleadoRepository() {
    }
    public LoginResult login (int dni, String password){
        String mensaje ;
     try(Session session=HibernateUtil.getSessionFactory().openSession()){
        //aqui va la consulta que vamos a realizar a la base de datos 
        String query ="FROM Empleado c WHERE c.dni = :dniparam";
        Empleado empleado = session.createQuery(query,Empleado.class)
                .setParameter("dniparam",dni)
                .uniqueResult();
    if(empleado==null){
       mensaje ="El dni no esta Registrado";
      return new LoginResult(false,mensaje);
    }
    else{
    boolean passok = PaswordHasher.verificar(password, empleado.getPassword());
    if(passok ==false){
    mensaje="la contraseña es incorrecta";
    return new LoginResult(false,mensaje);}
    else{
       SessionUsuario.login(empleado);
       return new LoginResult(true,"aprobado");
    }}
    }
    
    
    
    }
    
    public List<Empleado> listaDeEmpleados(){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        return session.createQuery("From Empleado",Empleado.class).list();
    }}
    
    
    public Empleado EmpleadoPorId(Long id){
        try(Session session =HibernateUtil.getSessionFactory().openSession()){
        return session.get(Empleado.class,id);}
        catch(Exception E){
            System.out.println("El Empleado no esta Registrado");
        return null;}                 
    }
    public Empleado empleadoPorDni(int dni){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        //aqui va la consulta que vamos a realizar a la base de datos 
        String query ="FROM Empleado c WHERE c.dni = :dniparam";
        return session.createQuery(query,Empleado.class)
                .setParameter("dniparam",dni)
                .uniqueResult();
               
        
    }catch(Exception E){
          System.out.println("Empleado no encontrado"+E); 
    return null;}
    
    }
    public Empleado crearEmpleado(Empleado empleadoNuevo){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    //guardar el cliente nuevo
    session.persist(empleadoNuevo);
    transaction.commit();
    return empleadoNuevo;
     }catch(Exception E){
     //si hubo un error verifica que la transaccion existe
     if(transaction != null&& transaction.getStatus().canRollback()){
     transaction.rollback();
     }
     return null;
     }
            
}
    public Empleado actualizarEmpleado(Empleado empleado){
    Transaction transaction = null;
    try(Session session = HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
  Empleado empleadoActualizado=  session.merge(empleado);
    transaction.commit();
     return empleadoActualizado;
    }catch(Exception E){
    if(transaction !=null){
    transaction.rollback();}
    }
        return null;
    
    }
    public void eliminarEmpleado(Long id){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction =session.beginTransaction();
    Empleado empleado = session.get(Empleado.class,id);
    if(empleado !=null){
    session.remove(empleado);
    transaction.commit();}
    }catch(Exception E){
    if (transaction !=null){
    transaction.rollback();}
   }
    }
}