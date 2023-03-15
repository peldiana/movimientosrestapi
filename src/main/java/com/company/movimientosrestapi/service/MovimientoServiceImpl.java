package com.company.movimientosrestapi.service;

import com.company.movimientosrestapi.entity.Cliente;
import com.company.movimientosrestapi.entity.Movimiento;
import com.company.movimientosrestapi.exceptions.RequestException;
import com.company.movimientosrestapi.repository.IMovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements IMovimientoService {

    private final IMovimientoRepository repository;

    @Override
    public Movimiento save(Movimiento movimiento) {
        //actualizarSaldo(movimiento);
        return this.repository.save(movimiento);
    }

    @Override
    public List<Movimiento> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void update(Long id, Movimiento movimiento) {
        Optional<Movimiento> optionalMovimiento = this.repository.findById(id);
        if (optionalMovimiento.isPresent()){
            Movimiento movimientoActualizado = optionalMovimiento.get();
            movimientoActualizado.setFecha(movimiento.getFecha());
            movimientoActualizado.setTipoMovimiento(movimiento.getTipoMovimiento());
            movimientoActualizado.setValor(movimiento.getValor());
            movimientoActualizado.setSaldo(movimiento.getSaldo());
            repository.save(movimientoActualizado);
        }else{
            throw new RequestException("Movimiento no encontrado", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public void deleteById(Long id) {
        Optional<Movimiento> optionalMovimiento = this.repository.findById(id);
        if (optionalMovimiento.isEmpty()) {
            throw new RequestException("Movimiento no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

    /*@Override
    public void actualizarSaldo(Movimiento movimiento) {
        double saldo = movimiento.getSaldo();
        double valor = movimiento.getValor();

        if (movimiento.getValor().compareTo(valor) == 0) {
            saldo = saldo - valor;
        }else{
            saldo = saldo + valor;
        }
    }*/

    /*@Override
    public List<Movimiento> findByCuentaIdOrderByFechaDesc(Long idCuenta) {
        return repository.findByCuentaIdOrderByFechaDesc(idCuenta);
    }*/
}
