package com.constructora.maquinarias_pesada.service;

import com.constructora.maquinarias_pesada.dto.ProductoDTO;
import com.constructora.maquinarias_pesada.dto.ProductoResponse;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProductoService {



    public ResponseEntity<ProductoResponse> productoDatosGson();


}
