
package controller;

import javax.swing.JOptionPane;
import model.Cliente;
import service.ClienteService;

public class ClienteController {
    ClienteService clienteService = new ClienteService();
     public Cliente buscarCliente(int dni){
      Cliente cliente = clienteService.buscarClientePorDni(dni);
       return cliente;
   }
   public Cliente registrarCliente(String nombre,String apellido,int dni){
   if(nombre.isEmpty()|| nombre==null||apellido.isEmpty()||apellido==null){
   JOptionPane.showMessageDialog(null,"ningun campo puede ser vacio o nulo");
   return null;
   }else{
   return clienteService.registrarCliente(nombre, apellido, dni);
   } 
   } 


}
