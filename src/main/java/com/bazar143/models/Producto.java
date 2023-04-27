package com.bazar143.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long codigoProducto;
    
    private String nombre;
    private String marca;
    private Double precio;
    private Double cantidadDisponible;
    
    @ManyToMany(mappedBy = "listaProductos")
    @JsonIgnore
    private List<Venta> listaVentas;
    
}
