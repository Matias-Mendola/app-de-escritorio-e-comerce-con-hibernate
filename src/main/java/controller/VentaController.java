
package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Empleado;
import model.LineaDeVenta;

import model.Producto;
import model.Venta;

import service.VentaService;


public class VentaController {
    VentaService ventaService = new VentaService();
    String[] columnasProducto ={"nombre","descripcion","categoria","precio"};
    String[] columnasVenta ={"producto","descripcion","cantidad","subtotal"};
    DefaultTableModel modeloProducto = new DefaultTableModel(columnasProducto,0){
    @Override
    public boolean isCellEditable(int row,int column){
    return false;}
    };
    DefaultTableModel modeloVenta = new DefaultTableModel(columnasVenta,0){
    @Override
    public boolean isCellEditable(int row,int column){
    return false;}
    };
    
    public JTable buscarElProductoPorNombre(String nombre,JTable tablaProductos){
        //limpiar la tabla para que los productos no se acumulen 
       modeloProducto = (DefaultTableModel) tablaProductos.getModel();
    modeloProducto.setRowCount(0); 
    tablaProductos.setModel(modeloProducto);
    if(nombre.isEmpty()||nombre ==null){
    tablaProductos.setModel(modeloProducto);
        return tablaProductos;}else{
    
    List<Producto> productos = ventaService.productosPorNombre(nombre);
    for(Producto p :productos){
        Object[] fila ={
        p,
        p.getDescripcion(),
        p.getCategoria(),
        p.getPrecio()
        };
    modeloProducto.addRow(fila);}
    tablaProductos.setModel(modeloProducto);
        return tablaProductos;
    
    }
    
    
    }
    public JTable buscarProductoPorId(Long id,JTable tablaProductos){    
    modeloProducto = (DefaultTableModel) tablaProductos.getModel();
    modeloProducto.setRowCount(0); 
    tablaProductos.setModel(modeloProducto);
        if(id!=null){
    ventaService.productoPorId(id);
    
    Producto p = ventaService.productoPorId(id);
    if(p !=null){
    Object[] fila ={
        p,
        p.getDescripcion(),
        p.getCategoria(),
        p.getPrecio()
        };
    modeloProducto.addRow(fila);
    }
    tablaProductos.setModel(modeloProducto);
        return tablaProductos;

    }
       tablaProductos.setModel(modeloProducto);
        return tablaProductos;
    }
    
    public JTable cargarTablaDeVenta(JTable tablaProductos,JTable tablaDeVentas){
        tablaDeVentas.setModel(modeloVenta);
    int filaSeleccionada = tablaProductos.getSelectedRow();
    if(filaSeleccionada== -1 ){
            return null;
    }else{
           Producto producto =(Producto) tablaProductos.getValueAt(filaSeleccionada,0);
            int cantidad = 1;
            Double subtotal = Double.valueOf(tablaProductos.getValueAt
                              (filaSeleccionada, 3).toString());
            String descripcion = tablaProductos.getValueAt(filaSeleccionada,1).toString();
                    
            Object[] nuevaFila={
                producto,
                descripcion,
                cantidad,
                subtotal
            
            };
            modeloVenta.addRow(nuevaFila);
            tablaDeVentas.setModel(modeloVenta);
            this.ActualizarTotal(tablaDeVentas);
    }
    
    return tablaDeVentas;
    }
   
    
   public void ActualizarTotal(JTable table){
   DefaultTableModel modelo = (DefaultTableModel) table.getModel();

    double suma = 0.0;
    int filaTotal = -1;

    for (int i = 0; i < modelo.getRowCount(); i++) {

        Object valorPrimeraColumna = modelo.getValueAt(i, 0);

        if ("--TOTAL--".equals(valorPrimeraColumna)) {
            filaTotal = i;
            continue;
        }

        Object valor = modelo.getValueAt(i, 3);

        if (valor != null) {
            suma += Double.parseDouble(valor.toString());
        }
    }

    if (filaTotal != -1) {
        modelo.setValueAt(suma, filaTotal, 3);

        if (filaTotal != modelo.getRowCount() - 1) {
            modelo.moveRow(filaTotal, filaTotal, modelo.getRowCount() - 1);
        }
    } else {
        modelo.addRow(new Object[]{"--TOTAL--", "", "", suma});
    }
        
   }
public void registarventa(JTable tablaDeVenta, Empleado empleado,Cliente cliente){
DefaultTableModel modelo = (DefaultTableModel)tablaDeVenta.getModel();
List<LineaDeVenta>detalles = new ArrayList<>();
for(int i =0;i<modelo.getRowCount()-1;i++){
Producto p = (Producto)modelo.getValueAt(i,0);
int cantidad =Integer.parseInt(modelo.getValueAt(i,2).toString());
Double subtotal = Double.parseDouble(modelo.getValueAt(i,3).toString());
LineaDeVenta lineaDeVenta = new LineaDeVenta(p,cantidad,subtotal);
detalles.add(lineaDeVenta);
}
Venta venta = ventaService.RegistarVenta(detalles, empleado, cliente);
if (venta==null){
JOptionPane.showMessageDialog(null,"No se pudo registrar la venta");
}else{
JOptionPane.showMessageDialog(null,"Venta Exitosa"
        + " Total"+venta.getTotal());

}
}
  
}
