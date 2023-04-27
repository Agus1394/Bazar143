package com.bazar143.controllers;

import com.bazar143.dto.VentaMayorDTO;
import com.bazar143.dto.VentaProductoDTO;
import com.bazar143.models.Venta;
import com.bazar143.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaController {
    
    @Autowired 
    private IVentaService ventaService;
    
    @PostMapping("/guardar")
    public String crear(@RequestBody Venta venta){
        ventaService.crear(venta);
        return "Venta registrada correctamente!";     
    }
          
    @GetMapping("/listaVentas")
    public List<Venta> traerVentas(){
        return ventaService.traerVentas(); 
    }
    
    @GetMapping("/{codigoVenta}")
    public Venta buscar(@PathVariable Long codigoVenta){
        Venta venta= ventaService.buscarVenta(codigoVenta);
        return venta;
    }
    
    @DeleteMapping("/eliminar/{codigoVenta}")
    public String borrar(@PathVariable Long codigoVenta){
        ventaService.borrar(codigoVenta);
        return "Venta eliminada!";
    }
    
    @PutMapping("/editar")
    public String editar(@RequestBody Venta venta){
        ventaService.editar(venta);
        return "Venta editada correctamente";
    }
    
    @GetMapping("/productosVentas/{codigoProducto}")
    public VentaProductoDTO traerVentaDeterminada(@PathVariable Long codigoProducto){ 
        return ventaService.traerVentaDeterminada(codigoProducto);
    }
    
    @GetMapping("/mayorVenta")
    public VentaMayorDTO obtenerVenta(){    
        return ventaService.obtenerVenta();
    }
    
    @ResponseBody
    @GetMapping("/total/{fecha}")
    public String obtenerTotal(@PathVariable String fechaVenta){
        LocalDate fecha= LocalDate.parse(fechaVenta);
        return ventaService.ventasPorDia(fecha);
    } 
    
}
