package com.company.movimientosrestapi.controller;

import com.company.movimientosrestapi.entity.Cuenta;
import com.company.movimientosrestapi.entity.Movimiento;
import com.company.movimientosrestapi.service.ICuentaService;
import com.company.movimientosrestapi.service.IMovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MovimientoController {

    private final IMovimientoService service;

    @PostMapping("movimientos")
    public ResponseEntity<Movimiento> crearMovimiento(@RequestBody Movimiento movimiento) {
        return new ResponseEntity(this.service.save(movimiento), HttpStatus.CREATED);
    }

    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> obtenerMovimiento(){
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/movimientos/{id}")
    public ResponseEntity<Void> actualizarMovimiento(@PathVariable("id") Long id, @RequestBody Movimiento movimiento){
        this.service.update(id, movimiento);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/movimientos/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable("id") Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
