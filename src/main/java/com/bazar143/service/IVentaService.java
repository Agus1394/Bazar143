package com.bazar143.service;

import com.bazar143.dto.VentaMayorDTO;
import com.bazar143.dto.VentaProductoDTO;
import com.bazar143.models.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public void crear(Venta venta);
    
    public void borrar(Long idVenta);
    
    public void editar(Venta venta);
    
    public List<Venta> traerVentas();
    
    public String ventasPorDia(LocalDate fecha); 
    
    public Venta buscarVenta(Long idVenta);
    
    public VentaMayorDTO obtenerVenta();
    
    public VentaProductoDTO traerVentaDeterminada(Long codigoVenta);
    
}
