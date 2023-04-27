package com.bazar143.controllers;

import com.bazar143.models.Producto;
import com.bazar143.service.IProductoService;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/guardar")
    public String crear(@RequestBody Producto producto) {
        productoService.crear(producto);
        return "Producto registrado correctamente!";
    }

    @GetMapping("/listaProducto")
    public List<Producto> traerProductos() {
        return productoService.traerProductos();
    }

    @GetMapping("/{codigoProducto}")
    public Producto buscar(@PathVariable Long codigoProducto) {
        Producto producto = productoService.buscar(codigoProducto);
        return producto;
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public String borrar(@PathVariable Long codigoProducto) {
        productoService.borrar(codigoProducto);
        return "Producto eliminado correctamente!";
    }

    @PutMapping("/productos/editar/{codigoProducto}")
    public Producto editar(@PathVariable Long codigoProducto,
            @RequestParam(required = false, name = "codigoProducto") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "marca") String nuevaMarca,
            @RequestParam(required = false, name = "precio") Double nuevoPrecio,
            @RequestParam(required = false, name = "cantidadDisponible") Double cantidadDisp) {

        productoService.editar(codigoProducto, idNueva, nuevoNombre, nuevaMarca,
                nuevoPrecio, cantidadDisp);
        Producto producto = productoService.buscar(codigoProducto);
        return producto;
    }
    
    @GetMapping("/traerStock")
    public List<Producto> traerStock(){      
        return productoService.traerStock();
    }
}
