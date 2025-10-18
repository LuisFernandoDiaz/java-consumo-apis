package com.constructora.maquinarias_pesada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {
    private String estado;
    private String fecha;
    private List<ProductoDTO> producto;
}
