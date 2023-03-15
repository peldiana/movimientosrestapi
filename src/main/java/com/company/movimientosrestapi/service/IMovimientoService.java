package com.company.movimientosrestapi.service;

import com.company.movimientosrestapi.entity.Movimiento;
import java.util.List;

public interface IMovimientoService {

    Movimiento save(Movimiento movimiento);

    List<Movimiento> findAll();
    void update(Long id, Movimiento movimiento);

    void deleteById(Long id);

    //void actualizarSaldo(Movimiento movimiento);

    //List<Movimiento> findByCuentaIdOrderByFechaDesc(Long idCuenta);
}
