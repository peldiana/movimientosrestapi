package com.company.movimientosrestapi.controller;

import com.company.movimientosrestapi.entity.Cliente;
import com.company.movimientosrestapi.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ClienteController {
    private final IClienteService service;

    @PostMapping("clientes")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity(this.service.save(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerClientes(){
       return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Void> actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente client){
        this.service.update(id, client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}