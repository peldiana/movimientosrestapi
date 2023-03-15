package com.company.movimientosrestapi.service;

import com.company.movimientosrestapi.entity.Cuenta;
import com.company.movimientosrestapi.exceptions.RequestException;
import com.company.movimientosrestapi.repository.ICuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements ICuentaService {

    private final ICuentaRepository repository;

    @Override
    public Cuenta save(Cuenta cuenta) {
        return this.repository.save(cuenta);
    }

    @Override
    public Optional<Cuenta> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Cuenta> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void update(Long id, Cuenta cuenta) {
        Optional<Cuenta> optionalCuenta = this.repository.findById(id);
        if (optionalCuenta.isPresent()){
            Cuenta cuentaActualizado = optionalCuenta.get();
            cuentaActualizado.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaActualizado.setTipoCuenta(cuenta.getTipoCuenta());
            cuentaActualizado.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaActualizado.setEstado(cuenta.getEstado());
            repository.save(cuentaActualizado);

        }else{
            throw new RequestException("Cuenta no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Cuenta> optionalCuenta = this.repository.findById(id);
        if (optionalCuenta.isEmpty()) {
            throw new RequestException("Cuenta no encontrada", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
