package com.company.movimientosrestapi.service;

import com.company.movimientosrestapi.entity.Cliente;
import com.company.movimientosrestapi.exceptions.RequestException;
import com.company.movimientosrestapi.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository repository;

    @Override
    public Cliente save(Cliente cliente) {
        return this.repository.save(cliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void update(Long id, Cliente cliente) {
        Optional<Cliente> optionalCliente = this.repository.findById(id);
        if (optionalCliente.isPresent()){
            Cliente clienteActualizado = optionalCliente.get();
            clienteActualizado.setNombre(cliente.getNombre());
            clienteActualizado.setGenero(cliente.getGenero());
            clienteActualizado.setEdad(cliente.getEdad());
            clienteActualizado.setIdentificacion(cliente.getIdentificacion());
            clienteActualizado.setDireccion(cliente.getDireccion());
            clienteActualizado.setTelefono(cliente.getTelefono());
            clienteActualizado.setContrasena(cliente.getContrasena());
            clienteActualizado.setEstado(cliente.getEstado());
            repository.save(clienteActualizado);
        }else{
            throw new RequestException("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Cliente> optionalCliente = this.repository.findById(id);
        if (optionalCliente.isEmpty()) {
            throw new RequestException("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}