
package main;

import model.Empleado;


public class SessionUsuario {
    public static  Empleado empleadoLogueado;
    
    public static void login(Empleado empleado){
    empleadoLogueado=empleado;}
    public static void lagout(){
        empleadoLogueado=null;}
    
    
    public Empleado getEmpleadoLogueado(){
    return empleadoLogueado;    }

 

}
