package com.bazar143.dto;

import com.bazar143.models.Producto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class VentaProductoDTO {
    private Long codigoVenta;
    private List<Producto> listaProducto;
}
