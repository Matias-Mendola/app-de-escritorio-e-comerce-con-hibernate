
package persistence;

import java.util.ArrayList;
import java.util.List;
import main.HibernateUtil;
import model.LineaDeVenta;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LineaDeVentaRepository {

    public LineaDeVentaRepository() {
    }    
    public LineaDeVenta lineaDeVentaPorId(Long id){
        try(Session session =HibernateUtil.getSessionFactory().openSession()){
        return session.get(LineaDeVenta.class,id);}
        catch(Exception E){
           
        return null;}                 
    }
   
    public List<LineaDeVenta> detallesPorVenta(Long idVenta){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
       
        String query ="FROM LineaDeVenta c JOIN FETCH c.producto WHERE c.venta.id =:idparam";
        return session.createQuery(query, LineaDeVenta .class)
               .setParameter("idparam", idVenta).list();
               
        
    }catch(Exception E){
          System.out.println("lineaDeVenta no encontrado"+E); 
    return new ArrayList<>();}
    
    }
    public LineaDeVenta crearLineaDeVenta(LineaDeVenta  lineaDeVenta){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    //guardar el cliente nuevo
    session.persist(lineaDeVenta);
    transaction.commit();
    return lineaDeVenta;
     }catch(Exception E){
     //si hubo un error verifica que la transaccion existe
     if(transaction != null&& transaction.getStatus().canRollback()){
     transaction.rollback();
     }
     return null;
     }
            
}
    public LineaDeVenta  actualizarLineaDeVenta(LineaDeVenta lineaDeVenta){
    Transaction transaction = null;
    try(Session session = HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    session.merge(lineaDeVenta);
    transaction.commit();
       
    }catch(Exception E){
    if(transaction !=null){
    transaction.rollback();}
    }
        return null;
    
    }
    public void eliminarLineaDeVenta(Long id){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction =session.beginTransaction();
    LineaDeVenta lineaDeVenta = session.get(LineaDeVenta .class,id);
    if(lineaDeVenta !=null){
    session.remove(lineaDeVenta);
    transaction.commit();}
    }catch(Exception E){
    if (transaction !=null){
    transaction.rollback();}
   }
    }
    
}