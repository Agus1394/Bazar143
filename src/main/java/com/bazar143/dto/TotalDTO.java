package com.bazar143.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TotalDTO {
    private LocalDate fecha;
    private Double cantidadVenta;
    private Double total;   
}
