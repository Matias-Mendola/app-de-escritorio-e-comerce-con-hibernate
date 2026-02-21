
package persistence;

import java.util.List;
import main.HibernateUtil;
import model.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteRepository {

    public ClienteRepository() {
    }
    public List<Cliente> listaDeClientes(){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        return session.createQuery("From Cliente",Cliente.class).list();
    }}
    
    
    public Cliente ClientePorId(Long id){
        try(Session session =HibernateUtil.getSessionFactory().openSession()){
        return session.get(Cliente.class,id);}
        catch(Exception E){
            System.out.println("El Cliente no esta Registrado");
        return null;}                 
    }
    public Cliente clientePorDni(int dni){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        //aqui va la consulta que vamos a realizar a la base de datos 
        String query ="FROM Cliente c WHERE c.dni =:dniparam";
        return session.createQuery(query, Cliente.class)
               .setParameter("dniparam", dni)
                .uniqueResult();
               
        
    }catch(Exception E){
          System.out.println("Cliente no encontrado"+E); 
    return null;}
    
    }
    public Cliente crearCliente(Cliente clienteNuevo){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    //guardar el cliente nuevo
    session.persist(clienteNuevo);
    transaction.commit();
    return clienteNuevo;
     }catch(Exception E){
     //si hubo un error verifica que la transaccion existe
     if(transaction != null&& transaction.getStatus().canRollback()){
     transaction.rollback();
     }
     return null;
     }
            
}
    public Cliente actualizarCliente(Cliente cliente){
    Transaction transaction = null;
    try(Session session = HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    session.merge(cliente);
    transaction.commit();
       
    }catch(Exception E){
    if(transaction !=null){
    transaction.rollback();}
    }
        return null;
    
    }
    public void eliminarCliente(Long id){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction =session.beginTransaction();
    Cliente cliente = session.get(Cliente.class,id);
    if(cliente !=null){
    session.remove(cliente);
    transaction.commit();}
    }catch(Exception E){
    if (transaction !=null){
    transaction.rollback();}
   }
    }
}
