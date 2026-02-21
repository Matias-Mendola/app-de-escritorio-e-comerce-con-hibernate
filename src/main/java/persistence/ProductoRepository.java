
package persistence;

import java.util.ArrayList;
import java.util.List;
import main.HibernateUtil;
import model.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductoRepository {

    public ProductoRepository() {
    }
    public List<Producto> listaDeProducto(){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        return session.createQuery("From Producto",Producto.class).list();
    }}
    
    
    public Producto ProductoPorId(Long id){
        try(Session session =HibernateUtil.getSessionFactory().openSession()){
        return session.get(Producto.class,id);}
        catch(Exception E){
            System.out.println("producto no encontrado");
        return null;}                 
    }
    public List<Producto> productosConStockBajo(){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
    String consulta = "From Producto c WHERE c.stock < 10 ";
    return session.createQuery(consulta,Producto.class).list();
    
    }catch(Exception E){
        return new ArrayList<>();
    }
        
        }
    public List<Producto> productoPorNombre(String nombre){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        //aqui va la consulta que vamos a realizar a la base de datos 
        String query ="FROM Producto c WHERE c.nombre LIKE :nombreparam";
        Query<Producto> productos= session.createQuery(query,Producto.class);
        productos.setParameter("nombreparam","%"+nombre+"%");
         return productos.getResultList();
        
    }catch(Exception E){
          System.out.println("Producto no encontrado"+E); 
    return new ArrayList<>();}
    
    }
     public List<Producto> productoPorCategoria(String categoria){
    try(Session session=HibernateUtil.getSessionFactory().openSession()){
        //aqui va la consulta que vamos a realizar a la base de datos 
        String query ="FROM Producto c WHERE c.categoria =:categoriaparam";
        Query<Producto> productos= session.createQuery(query,Producto.class);
        productos.setParameter("categoriaparam",categoria);
         return productos.getResultList();
        
    }catch(Exception E){
          System.out.println("Producto no encontrado"+E); 
    return new ArrayList<>();}
     }
    public Producto crearProducto(Producto productoNuevo){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    //guardar el Producto nuevo
    session.persist(productoNuevo);
    transaction.commit();
    return productoNuevo;
     }catch(Exception E){
     //si hubo un error verifica que la transaccion existe
     if(transaction != null&& transaction.getStatus().canRollback()){
     transaction.rollback();
     }
     return null;
     }
            
}
    public Producto actualizarProducto(Producto producto){
    Transaction transaction = null;
    try(Session session = HibernateUtil.getSessionFactory().openSession()){
    transaction = session.beginTransaction();
    session.merge(producto);
    transaction.commit();
       
    }catch(Exception E){
    if(transaction !=null){
    transaction.rollback();}
    }
        return null;
    
    }
    public String eliminarProducto(Long id){
    Transaction transaction = null;
    try(Session session =HibernateUtil.getSessionFactory().openSession()){
    transaction =session.beginTransaction();
    Producto producto = session.get(Producto.class,id);
    if(producto !=null){
    session.remove(producto);
    transaction.commit();
    return "El producto ha sido Eliminado";}
    }catch(Exception E){
    if (transaction !=null){
    transaction.rollback();}
   }
    return "No se pudo Eliminar el producto";}
    
    
    //metodo para tomar laas categorias de los productos de la base de datos
   public List<String> categoriasDeProducto(){
       List<String> categorias = new ArrayList<>();
     try(Session session = HibernateUtil.getSessionFactory().openSession()){
       String consulta ="Select DISTINCT p.categoria FROM Producto p";
       categorias = session.createQuery(consulta, String.class).getResultList();
       return categorias;
     
       }catch(Exception E){
       return new ArrayList<>();
       } 
        
        
        
        
    } 
 
   
   
   
}
