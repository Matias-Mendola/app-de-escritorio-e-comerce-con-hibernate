
package controller;

import model.LoginResult;
import service.EmpleadoService;

public class LoginController {
    public LoginResult login(int dni,String password){
        LoginResult respuesta = null;
    if(password!=null){
    EmpleadoService empleadoService = new EmpleadoService();
    respuesta= empleadoService.Login(dni, password);
    return respuesta;
    } else{
    respuesta.setResult(false);
    respuesta.setMensaje("el password esta vacio");
    return respuesta;
    }
    
    
    }
}
