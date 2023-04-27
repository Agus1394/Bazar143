package com.bazar143.dto;

import com.bazar143.models.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaMayorDTO {

    private Long codigoVenta;
    private Double total;
    private Double cantidadDisponible;
    private String nombre;
    private String apellido;

    @JsonIgnore
    private List<Producto> listaProductos;
}
