package com.bazar143.controllers;

import com.bazar143.models.Cliente;
import com.bazar143.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/listaCliente")
    public List<Cliente> traerClientes() {
        return clienteService.traerClientes();
    }

    @GetMapping("/{idCliente}")
    public Cliente buscar(@PathVariable Long idCliente) {
        Cliente cliente = clienteService.buscar(idCliente);
        return cliente;
    }

    @PostMapping("/guardar")
    public String crear(@RequestBody Cliente cliente) {
        clienteService.crear(cliente);
        return "Cliente registrado correctamente!";
    }

    //probar en postman
    @PutMapping("/editar/{idCliente}")
    public Cliente editar(@PathVariable Long idCliente,
            @RequestParam(required = false, name = "id_cliente") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "dni") String nuevoDni) {

        clienteService.editar(idCliente, idNueva, nuevoNombre,
                nuevoApellido, nuevoDni);
        Cliente cliente = clienteService.buscar(idNueva);
        return cliente;
    }
    
    @DeleteMapping("borrar/{idCliente}")
    public String eliminar(@PathVariable Long idCliente){
        clienteService.borrar(idCliente);
        return "Cliente eliminado!";       
    }
}
