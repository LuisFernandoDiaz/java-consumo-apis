package com.constructora.maquinarias_pesada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawProductoResponse {
    private String estado;
    private String fecha; // puedes usar ZonedDateTime/OffsetDateTime si prefieres (ver nota abajo)
    private List<List<ProductoDTO>> producto;
}
