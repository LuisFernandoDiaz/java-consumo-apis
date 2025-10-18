package com.constructora.maquinarias_pesada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private String nombre;
    private String marca;
    private String cantidadDescripcion;
    private double precio;
}
