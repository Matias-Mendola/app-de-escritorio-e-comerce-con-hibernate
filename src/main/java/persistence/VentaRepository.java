
package persistence;

import java.util.ArrayList;
import java.util.List;
import main.HibernateUtil;
import model.Venta;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VentaRepository {

    public VentaRepository() {
    }    
    public Venta VentaPorId(Long id){
        try(Session session =HibernateUtil.getSessionFactory().openSession()){
        return session.get(Venta.class,id);}
        catch(Exception E){
           
        return null;}                 
    }
     public List<Venta> ventasPorEmpleado(long idEmpleado){
    try(Session session = HibernateUtil.getSessionFactory().openSession()){
    String query =  "From Venta c WHERE c.empleado.id = :idEmpleadoParam";
    return session.createQuery(query,Venta.class)
            .setParameter("idEmpleadoParam",idEmpleado).list();
    }catch(Exception E){
        System.out.println("ha ocurrido un error");
    return new ArrayList<>();}
    
    
    }
     public List<Venta> ventasPorCliente(long idCliente){
    try(Session session = HibernateUtil.getSessionFactory().openSession()){
    String query =  "From Venta c WHERE c.cliente.id = :idClienteParam";
    return session.createQuery(query,Venta.class)
            .setParameter("idClienteParam",idCliente).list();
    }catch(Exception E){
        System.out.println("ha ocurrido un error");
    return new ArrayList<>();}
    
    
    }
    
    public List<Venta> listaDeVentas(){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        //aqui va la consulta que vamos a realizar a la base de datos 
        String query ="FROM Venta ";
        return session.createQuery(query, Venta.class).list();
            
               
        
    }catch(Exception E){
          System.out.println("lineaDeVenta no encontrado"+E); 
    return new ArrayList<>();}
    
    }
    public Venta crearVenta(Venta venta){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
   
    session.persist(venta);
   transaction.commit();
return venta;
  
    }catch(Exception E){
     //si hubo un error verifica que la transaccion existe
     if(transaction != null&& transaction.getStatus().canRollback()){
     transaction.rollback();
     }
    
     }
    return null;      
}
    public Venta editarVenta(Venta venta){
    Transaction transaction = null;
    try(Session session = HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    session.merge(venta);
    transaction.commit();
       
    }catch(Exception E){
    if(transaction !=null){
    transaction.rollback();}
    }
        return null;
    
    }
    public void eliminarVenta(Long id){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction =session.beginTransaction();
    Venta venta = session.get(Venta .class,id);
    if(venta !=null){
    session.remove(venta);
    transaction.commit();}
    }catch(Exception E){
    if (transaction !=null){
    transaction.rollback();}
   }
    }
}