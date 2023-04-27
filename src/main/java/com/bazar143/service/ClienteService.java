package com.bazar143.service;

import com.bazar143.models.Cliente;
import com.bazar143.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;
    
    @Override
    public void crear(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void borrar(Long idCliente) {
        clienteRepo.deleteById(idCliente);
    }

    @Override
    public void editar(Long idCliente, Long nuevoId,
            String nombre, String apellido, String dni) {

        Cliente cliente= this.buscar(idCliente);
        
        cliente.setIdCliente(nuevoId);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        
        this.crear(cliente);
    }

    @Override
    public List<Cliente> traerClientes() {
        List<Cliente> traerClientes= clienteRepo.findAll();
        return traerClientes;
    }

    @Override
    public Cliente buscar(Long idCliente) {
        return clienteRepo.findById(idCliente).orElse(null);
    }
    
}
