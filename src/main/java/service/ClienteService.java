
package service;

import model.Cliente;
import persistence.ClienteRepository;

public class ClienteService {
    ClienteRepository clienteRepository = new ClienteRepository();
    public Cliente buscarClientePorDni(int dni){
    return clienteRepository.clientePorDni(dni);
    }
    
    public Cliente registrarCliente(String nombre, String apellido, int dni){
    Cliente cliente = new Cliente(nombre,apellido,dni);
        
        
        return clienteRepository.crearCliente(cliente);
    
    }
    
}
