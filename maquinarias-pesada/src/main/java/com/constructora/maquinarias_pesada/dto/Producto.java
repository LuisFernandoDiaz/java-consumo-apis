package com.constructora.maquinarias_pesada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private String marca;
    private int cantidad;
    private double precio;
    private double descuento;
    private String descripcion;
}
