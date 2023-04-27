package com.bazar143.service;

import com.bazar143.models.Producto;
import com.bazar143.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository productoRepo;

    @Override
    public void crear(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void borrar(Long idProducto) {
        productoRepo.deleteById(idProducto);
    }

    @Override
    public void editar(Long codigoProducto, Long idNuevo,
            String nombre, String marca,
            Double precio, Double cantidadDisponible) {

        Producto producto = new Producto();
        producto.setCodigoProducto(idNuevo);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setPrecio(precio);
        producto.setCantidadDisponible(cantidadDisponible);

        this.crear(producto);
    }

    @Override
    public List<Producto> traerProductos() {
        List<Producto> traerProductos = productoRepo.findAll();
        return traerProductos;
    }

    /*
    Método que obtiene la lista de productos cuya cantidad disponible
    es menor 5.
    */
    @Override
    public List<Producto> traerStock() {
        List<Producto> listaProductos= this.traerProductos();
        List<Producto> listaStock= new ArrayList<Producto>();

        for (Producto producto : listaProductos) {
            if (producto.getCantidadDisponible() < 5) {
                listaStock.add(producto);
            }
        }
        return listaStock;      
    }

    @Override
    public Producto buscar(Long idProducto) {
        return productoRepo.findById(idProducto).orElse(null);
    }

}
