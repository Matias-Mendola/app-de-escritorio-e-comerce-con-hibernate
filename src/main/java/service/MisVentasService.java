
package service;

import java.util.List;
import model.Empleado;
import model.Venta;
import persistence.VentaRepository;

public class MisVentasService {
    VentaRepository ventaRepository = new VentaRepository();
    public List<Venta> ventasPorEmpleado(Empleado empleado){
    return ventaRepository.ventasPorEmpleado(empleado.getId());
    }

 
}
