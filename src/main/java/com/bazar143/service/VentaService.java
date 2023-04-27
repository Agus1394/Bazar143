package com.bazar143.service;

import com.bazar143.dto.VentaMayorDTO;
import com.bazar143.dto.VentaProductoDTO;
import com.bazar143.models.Venta;
import com.bazar143.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public void crear(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void borrar(Long idVenta) {
        ventaRepo.deleteById(idVenta);
    }

    @Override
    public void editar(Venta venta) {
        this.crear(venta);
    }

    @Override
    public List<Venta> traerVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public Venta buscarVenta(Long idVenta) {
        return ventaRepo.findById(idVenta).orElse(null);
    }

    /*
    Método que obtiene una lista de productos
    de una venta determinada
     */
    @Override
    public VentaProductoDTO traerVentaDeterminada(Long codigoVenta) {
        VentaProductoDTO ventaDto = new VentaProductoDTO();
        Venta venta = this.buscarVenta(codigoVenta);

        ventaDto.setCodigoVenta(venta.getCodigoVenta());
        ventaDto.setListaProducto(venta.getListaProductos());

        return ventaDto;
    }

    /*
    Método que obtiene la cantidad total de ventas y el monto
    total por día
     */
    @Override
    public String ventasPorDia(LocalDate fecha) {
        double monto = 0;
        int cant = 0;
        List<Venta> listaVentas = this.traerVentas();

        for (Venta venta : listaVentas) {
            if (venta.getFechaVenta().equals(fecha)) {
                monto = monto + venta.getTotal();
                cant++;
            }
        }
        return "La cantidad de ventas del dia " + fecha + " es: " + cant + ", con monto total de: $" + monto + " pesos.";
    }

    /*
    Método que obtiene el código de venta, el total, cantidad de productos,
    apellido y nombre del cliente y la venta con el monto más alto de todas.
     */
    @Override
    public VentaMayorDTO obtenerVenta() {
        VentaMayorDTO mayorDto = new VentaMayorDTO();
        List<Venta> listaVentas = this.traerVentas();
        Double total = 0.0, temporal = 0.0, contador = 0.0;
        for (Venta venta : listaVentas) {
            temporal = venta.getTotal();
            if (temporal > total) {
                total = temporal;
                Double roundTotal = Math.round(total * 100) / 100.0;
                mayorDto.setTotal(roundTotal);
                mayorDto.setCodigoVenta(venta.getCodigoVenta());
                mayorDto.setNombre(venta.getCliente().getNombre());
                mayorDto.setApellido(venta.getCliente().getApellido());
                mayorDto.setListaProductos(venta.getListaProductos());

                for (int i = 0; i < mayorDto.getListaProductos().size(); i++) {
                    contador++;
                    mayorDto.setCantidadDisponible(contador);
                }
            }
        }
        return mayorDto;
    }

}
