
package controller;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Producto;
import service.ProductoService;
public class ProductoController {
    ProductoService productoService =new  ProductoService();
   String[] columnasProducto ={"Id","Nombre","Descripcion","Categoria","Precio","Stock"};
    DefaultTableModel modeloProducto = new DefaultTableModel(columnasProducto,0){
    @Override
    public boolean isCellEditable(int row,int column){
    return false;}
    };
    
public JComboBox cargarComboBox(JComboBox categoriasBox) {
 DefaultComboBoxModel model = new DefaultComboBoxModel<>(); 
         model.addElement("Seleccione Categoria");
         List<String> categorias = productoService.categoriasDeProductos();
         if(categorias.isEmpty()){
         JOptionPane.showMessageDialog(null,"la lista esta vacia");
         return null;
         }
         else{
          for(String cat:categorias){
         model.addElement(cat);
         }
       
         categoriasBox.setModel(model);
         return categoriasBox;
         }
         

}
    public JComboBox cargarComboBox2(JComboBox categorias2){
  DefaultComboBoxModel model = new DefaultComboBoxModel<>(); 
         model.addElement("Seleccione Categoria");
         List<String> categorias = productoService.categoriasDeProductos();
         if(categorias.isEmpty()){
         JOptionPane.showMessageDialog(null,"la lista esta vacia");
        return null;}
         else
         {
          for(String cat:categorias){
         model.addElement(cat);
         }
       
         categorias2.setModel(model);
         return categorias2;
         }
        
  } 
  public JTable productoPorId(Long id,JTable tabla){
  Producto producto =productoService.buscarProductoPorId(id);
  //liampia la tabla de los productos anteriores
  modeloProducto = (DefaultTableModel)tabla.getModel();
  modeloProducto.setRowCount(0);
  if(producto!=null){
  Object[]fila ={
  producto.getId(),
      producto,
      producto.getDescripcion(),
      producto.getCategoria(),
      producto.getPrecio(),
      producto.getStock()
      
  };
  modeloProducto.addRow(fila);
  tabla.setModel(modeloProducto);
  return tabla;
  }
  
return null;}
public JTable productoPorNombre(String nombre, JTable tabla){
List<Producto> productos = productoService.BuscarProductoPorNombre(nombre);
  //liampia la tabla de los productos anteriores
  modeloProducto = (DefaultTableModel)tabla.getModel();
  modeloProducto.setRowCount(0);
  if(productos.isEmpty()){
  JOptionPane.showMessageDialog(null,"no se Encontraron productos");
  return null;}else{
  for(Producto p : productos){
  Object[] fila ={
        p.getId(),
        p,
        p.getDescripcion(),
        p.getCategoria(),
        p.getPrecio(),
        p.getStock()
  };
  modeloProducto.addRow(fila);
  }
  tabla.setModel(modeloProducto);
  return tabla; 
  }
}
public JTable productosConBajoStock(JTable tabla){
     modeloProducto = (DefaultTableModel)tabla.getModel();
  modeloProducto.setRowCount(0);
List<Producto> productos = productoService.bajoStock();
  //liampia la tabla de los productos anteriores
 
  if(productos.isEmpty()){
  JOptionPane.showMessageDialog(null,"No existen productos con Stock reducido");
  return tabla;
  }else{
  for(Producto p : productos){
        Object[]fila = {
                 p.getId(),
                 p,
                 p.getDescripcion(),
                 p.getCategoria(),
                 p.getPrecio(),
                 p.getStock()
  };
        modeloProducto.addRow(fila);
  }
  tabla.setModel(modeloProducto);
  return tabla;}
}
public JTable buscarPorCategoria(String categoria,JTable tabla){
List<Producto> productos = productoService.buscarPorCategoria(categoria);
  //liampia la tabla de los productos anteriores
  modeloProducto = (DefaultTableModel)tabla.getModel();
  modeloProducto.setRowCount(0);
  if(productos.isEmpty()){
  JOptionPane.showMessageDialog(null,"No existen productos Asociado a esta categoria");
  return tabla;
  }else{
  for(Producto p : productos){
        Object[]fila = {
                 p.getId(),
                 p,
                 p.getDescripcion(),
                 p.getCategoria(),
                 p.getPrecio(),
                 p.getStock()
  };
        modeloProducto.addRow(fila);
  }
  tabla.setModel(modeloProducto);
  return tabla;}
}
public Producto agregarProducto(String nombre,String descripcion,String categoria
                              ,int stock,Double precio){
Producto producto = new Producto(nombre,descripcion,categoria,stock,precio);
return productoService.crearProducto(producto);
}
public String eliminarProducto(Producto producto){
return productoService.eliminarProducto(producto);
}
public String editarProdcuto(Long id,String nombre, String descripcion,String categoria,
                               Double precio,int cantidad){
    String mensaje ="";


return mensaje;}
public JTable listarTodosLosProductos(JTable tablaProductos){
modeloProducto.setRowCount(0);
    tablaProductos.setModel(modeloProducto);
List<Producto>productos = productoService.allProductos();
if(productos.isEmpty()){
return null;
}else{
for(Producto p:productos){
Object[]fila={
        p.getId(),
        p,
        p.getDescripcion(),
        p.getCategoria(),
        p.getPrecio(),
        p.getStock()};
modeloProducto.addRow(fila);
}
tablaProductos.setModel(modeloProducto);
return tablaProductos;}
}

}


