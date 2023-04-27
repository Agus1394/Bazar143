package com.bazar143.service;

import com.bazar143.models.Cliente;
import java.util.List;


public interface IClienteService {
    
    public void crear(Cliente cliente);
    
    public void borrar(Long idCliente);
    
    public void editar(Long idCliente, Long nuevoId,
            String nombre, String apellido, String dni);
    
    public List<Cliente> traerClientes();
    
    public Cliente buscar(Long idCliente);
}
