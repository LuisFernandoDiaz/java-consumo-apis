package com.constructora.maquinarias_pesada.service.serviceImpl;

import com.constructora.maquinarias_pesada.dto.Producto;
import com.constructora.maquinarias_pesada.dto.ProductoDTO;
import com.constructora.maquinarias_pesada.dto.ProductoResponse;
import com.constructora.maquinarias_pesada.dto.RawProductoResponse;
import com.constructora.maquinarias_pesada.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ProductoServiceImpl implements ProductoService {


    private final RestTemplate restTemplate;

    public ProductoServiceImpl(RestTemplate _restTemplate){
        this.restTemplate = _restTemplate;
    }



    @Override
    public ResponseEntity<ProductoResponse> productoDatosGson() {
        // ✅ Endpoint a consumir
        String url = "https://localhost:7127/api/Prenda";

        // Obtenemos la respuesta inicial
        RawProductoResponse body = restTemplate.getForObject(url, RawProductoResponse.class);
        List<ProductoDTO> productos = new ArrayList<>();

        if (body == null) {
            ProductoResponse response = new ProductoResponse(
                    String.valueOf(HttpStatus.NOT_FOUND.value()),
                    null,
                    Collections.emptyList()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.valueToTree(body);

            // ✅ Campos principales
            String estado = jsonNode.path("estado").asText("error");
            String fecha = jsonNode.path("fecha").asText("");

            // ✅ Procesamos el arreglo anidado de productos
            JsonNode productoArray = jsonNode.path("producto");
            if (productoArray.isArray()) {
                for (JsonNode listaInterna : productoArray) {
                    for (JsonNode nodo : listaInterna) {
                        String nombre = nodo.path("nombre").asText();
                        String marca = nodo.path("marca").asText();
                        int cantidad = nodo.path("cantidad").asInt();
                        double precio = nodo.path("precio").asDouble();

                        String cantidadDesc = stockDisponible(cantidad);
                        productos.add(new ProductoDTO(nombre, marca, cantidadDesc, precio));
                    }
                }
            }

            // ✅ Construimos la respuesta final
            ProductoResponse response = new ProductoResponse(estado, fecha, productos);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // En caso de error inesperado al parsear
            ProductoResponse errorResponse = new ProductoResponse(
                    "error",
                    null,
                    Collections.emptyList()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // 🔹 Método auxiliar: descripción del stock
    public String stockDisponible(int cantidad) {
        if (cantidad < 10) return "quedan pocos";
        if (cantidad <= 30) return "estás a tiempo";
        return "stock disponible";
    }



}
