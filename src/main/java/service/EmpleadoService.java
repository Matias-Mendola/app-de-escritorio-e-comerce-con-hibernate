
package service;

import main.PaswordHasher;
import model.Empleado;
import model.LoginResult;
import persistence.EmpleadoRepository;

public class EmpleadoService {
    EmpleadoRepository empleadoRepository = new EmpleadoRepository();
    public LoginResult Login (int dni,String password){   
    LoginResult respuesta = empleadoRepository.login(dni, password);
    return respuesta;
    }
    public Empleado editarEmpleado(Long id,String nombre,String apellido, int dni ,String pasword){
   String hash =PaswordHasher.hash(pasword);      
    Empleado empleado =  empleadoRepository.EmpleadoPorId(id);
    empleado.setNombre(nombre);
    empleado.setApellido(apellido);
    empleado.setDni(dni);
    empleado.setPassword(hash);
   return empleadoRepository.actualizarEmpleado(empleado); }
    public Empleado buscarPorDni(int dni){
    return empleadoRepository.empleadoPorDni(dni);
    }
    public Empleado primerIngreso(Empleado empleado){
    return empleadoRepository.actualizarEmpleado(empleado);
    }
}
