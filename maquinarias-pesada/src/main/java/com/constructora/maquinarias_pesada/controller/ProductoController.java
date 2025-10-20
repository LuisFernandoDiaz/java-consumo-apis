package com.constructora.maquinarias_pesada.controller;


import com.constructora.maquinarias_pesada.dto.ProductoDTO;
import com.constructora.maquinarias_pesada.dto.ProductoResponse;
import com.constructora.maquinarias_pesada.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    public ProductoService productoService;


    @GetMapping(produces = "application/json")
    public ResponseEntity<ProductoResponse> allEmpleado(){
        try{
            return productoService.productoDatosGson();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }


}
