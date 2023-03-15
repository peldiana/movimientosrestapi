package com.company.movimientosrestapi.service;

import com.company.movimientosrestapi.entity.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ICuentaService {

    Cuenta save(Cuenta cuenta);

    Optional<Cuenta> findById(Long id);

    List<Cuenta> findAll();

    void update(Long id, Cuenta cuenta);

    void deleteById(Long id);
}
