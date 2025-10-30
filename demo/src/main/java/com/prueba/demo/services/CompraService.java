package com.prueba.demo.services;
import com.prueba.demo.entity.Compra;
import com.prueba.demo.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    public void guardarCompra(Compra compra) {
        compraRepository.save(compra);
    }
}
