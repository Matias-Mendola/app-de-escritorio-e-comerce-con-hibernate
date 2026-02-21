
package controller;

import main.PaswordHasher;
import model.Empleado;
import service.EmpleadoService;

public class EmpleadoController {
   EmpleadoService empleadoService = new EmpleadoService();  
   public Empleado buscarPorDNI(int dni){
   return empleadoService.buscarPorDni(dni);}
   
  public boolean primerIngreso(String passwor,Empleado empleado){
  String hash = PaswordHasher.hash(passwor);
  empleado.setPassword(hash);
       return empleadoService.primerIngreso(empleado)!=null;
  
  } 
   
}
