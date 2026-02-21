
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.SessionUsuario;
import model.Empleado;
import model.LineaDeVenta;
import model.Venta;
import service.MisVentasService;
import service.VentaService;

public class MisVentasController {
    String [] columnas = {"Id Cliente","Fecha y Hora","Articulos","total","Id Venta"};
    DefaultTableModel modeloVenta = new DefaultTableModel(columnas,0){
    @Override
    public boolean isCellEditable(int row,int column){
    return false;}
    };
    MisVentasService ventaService = new MisVentasService();
    Empleado empleado = SessionUsuario.empleadoLogueado;
    VentaService serviceVenta = new VentaService();
    
     public JTable cargarTablaDeVenta(JTable tablaDeVenta){
         tablaDeVenta.setModel(modeloVenta);
     List<Venta> ventas = ventaService.ventasPorEmpleado(empleado);
    if(ventas.isEmpty()){
    return null;
    }else{
        for(Venta v:ventas){
        Object[] fila={
          v.getCliente().getId(),
          v.getFechaHora(),
          v.getArticulos(),
          v.getTotal(),
          v
        
        };
        modeloVenta.addRow(fila);
        
        }
        tablaDeVenta.setModel(modeloVenta);
        return tablaDeVenta;
    }
     
     }
     
     
     public JTable cargarTablaDeDetalles(Venta venta,JTable tablaDeDetalles){
     String[]columnas={"producto","descripcion","cantidad","precio"};
     DefaultTableModel modelo = new DefaultTableModel(columnas,0){
     @Override
     public boolean isCellEditable(int row,int column){
     return false;}};
     tablaDeDetalles.setModel(modelo);
        
     List<LineaDeVenta> detalles = serviceVenta.traerDetalles(venta);
     for(LineaDeVenta l:detalles){
     Object[]fila = {
                l.getProducto(),
                l.getProducto().getDescripcion(),
                l.getCantidad(),
                l.getProducto().getPrecio()};
     modelo.addRow(fila);
     }
     tablaDeDetalles.setModel(modelo);
     
     return tablaDeDetalles;}
    
    
}
