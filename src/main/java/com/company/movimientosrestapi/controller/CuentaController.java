package com.company.movimientosrestapi.controller;

import com.company.movimientosrestapi.entity.Cuenta;
import com.company.movimientosrestapi.service.ICuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CuentaController {

    private final ICuentaService service;

    @PostMapping("cuentas")
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        return new ResponseEntity(this.service.save(cuenta), HttpStatus.CREATED);
    }

    @GetMapping("/cuentas")
    public ResponseEntity<List<Cuenta>> obtenerCuentas(){
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/cuentas/{id}")
    public ResponseEntity<Void> actualizarCuenta(@PathVariable("id") Long id, @RequestBody Cuenta cuenta){
        this.service.update(id, cuenta);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cuentas/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable("id") Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
