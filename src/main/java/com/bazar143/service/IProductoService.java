package com.bazar143.service;

import com.bazar143.models.Producto;
import java.util.List;

public interface IProductoService {

    public void crear(Producto producto);

    public void borrar(Long idProducto);

    public void editar(Long codigoProducto, Long idNuevo,
            String nombre, String marca,
            Double precio, Double cantidadDisponible);

    public List<Producto> traerProductos();
    
    //Método que obtiene la cantidadDisponible menor a 5
    public List<Producto> traerStock();

    public Producto buscar(Long idProducto);

}
