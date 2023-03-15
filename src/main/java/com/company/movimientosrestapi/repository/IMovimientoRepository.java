package com.company.movimientosrestapi.repository;

import com.company.movimientosrestapi.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {

}
