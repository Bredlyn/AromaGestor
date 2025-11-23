package com.prueba.demo.services;

import com.prueba.demo.document.Cliente;
import com.prueba.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public List<Cliente> listar() {
        return clienteRepo.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public void eliminar(String id) {
        clienteRepo.deleteById(id);
    }

    public Cliente buscarPorId(String id) {
        return clienteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
