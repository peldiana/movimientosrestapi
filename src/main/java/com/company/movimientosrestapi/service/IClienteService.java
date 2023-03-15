package com.company.movimientosrestapi.service;

import com.company.movimientosrestapi.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    Cliente save(Cliente cliente);

    Optional<Cliente> findById(Long id);

    List<Cliente> findAll();

    void update(Long id, Cliente cliente);

    void deleteById(Long id);

}
