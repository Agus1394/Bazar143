package com.bazar143.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    
    @ManyToMany
    @JoinTable(name = "ventaProducto",
            joinColumns = @JoinColumn(name="codigoVenta", nullable = false),
            inverseJoinColumns = @JoinColumn(name="codigoproducto", nullable = false))
    private List<Producto> listaProductos;
    
    @OneToOne
    @JoinColumn(name="idCliente", referencedColumnName="idCliente")
    private Cliente cliente;
    
}
