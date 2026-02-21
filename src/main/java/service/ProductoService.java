
package service;
import java.util.List;
import model.Producto;
import persistence.ProductoRepository;
public class ProductoService {
    ProductoRepository productoRepository =new  ProductoRepository();

public Producto buscarProductoPorId(Long id){
return this.productoRepository.ProductoPorId(id);
}
public List<Producto> BuscarProductoPorNombre(String nombre){
return this.productoRepository.productoPorNombre(nombre);
}
public Producto actualizarProducto(Producto producto){
return this.productoRepository.actualizarProducto(producto);

}
public void deleteProducto(Long id){
this.productoRepository.eliminarProducto(id);
}
public List<String> categoriasDeProductos(){

return this.productoRepository.categoriasDeProducto();
}
public Producto crearProducto(Producto producto){
return productoRepository.crearProducto(producto);
}
public List<Producto> bajoStock(){
return productoRepository.productosConStockBajo();
}
public List<Producto> buscarPorCategoria(String categoria){
return productoRepository.productoPorCategoria(categoria);}
public String eliminarProducto(Producto producto){
String mensaje = productoRepository.eliminarProducto(producto.getId());
return mensaje;}
public List<Producto> allProductos(){
return productoRepository.listaDeProducto();
}
        
}


