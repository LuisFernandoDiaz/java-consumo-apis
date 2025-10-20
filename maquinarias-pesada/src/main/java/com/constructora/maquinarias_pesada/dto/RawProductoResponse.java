package com.constructora.maquinarias_pesada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RawProductoResponse {
    private String estado;
    private String fecha; // puedes usar ZonedDateTime/OffsetDateTime si prefieres (ver nota abajo)
    private List<List<ProductoDTO>> producto;

    public RawProductoResponse(String estado, String fecha, List<List<ProductoDTO>> producto) {
        this.estado = estado;
        this.fecha = fecha;
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<List<ProductoDTO>> getProducto() {
        return producto;
    }

    public void setProducto(List<List<ProductoDTO>> producto) {
        this.producto = producto;
    }
}
