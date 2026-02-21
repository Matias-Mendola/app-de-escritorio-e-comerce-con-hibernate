
package service;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Empleado;
import model.LineaDeVenta;
import model.Producto;
import model.Venta;
import persistence.LineaDeVentaRepository;
import persistence.ProductoRepository;
import persistence.VentaRepository;

public class VentaService {
    VentaRepository ventaRepository = new VentaRepository();
    ProductoRepository productoRepository = new ProductoRepository();
    public List<Producto> productosPorNombre(String nombre){
    List<Producto> productos= productoRepository.productoPorNombre(nombre);
    productos.removeIf(p-> p.getStock()<=0);
   return productos; }
   
    public Producto productoPorId(Long id){
   Producto producto =productoRepository.ProductoPorId(id);
        if(producto.getStock()<1){
        return null;
        }else{
        return producto;}
    
    }
    public Venta RegistarVenta(List<LineaDeVenta>detalles,Empleado empleado,Cliente cliente ){
    Double total =0.0;
    int articulos =0;
        for(LineaDeVenta l:detalles){
    l.getProducto().setStock(l.getProducto().getStock()-l.getCantidad());
    productoRepository.actualizarProducto(l.getProducto());
    total =total+(l.getCantidad()*(Double) l.getProducto().getPrecio());
    articulos = articulos+l.getCantidad();
        }
        
    Venta venta = new Venta(empleado,cliente,total
                            ,LocalDateTime.now(),articulos,detalles);
    for(LineaDeVenta l :detalles){
        l.setVenta(venta);}
         return ventaRepository.crearVenta(venta);
}
    public List<LineaDeVenta> traerDetalles(Venta venta){
    LineaDeVentaRepository linea= new LineaDeVentaRepository();
    List<LineaDeVenta> detalles= linea.detallesPorVenta(venta.getId()); 
   
    return detalles;
    }
}
