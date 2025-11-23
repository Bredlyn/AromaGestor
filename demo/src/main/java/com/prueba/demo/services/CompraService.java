package com.prueba.demo.services;

import com.prueba.demo.document.Compra;
import com.prueba.demo.repository.CompraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepo;

    public CompraService(CompraRepository compraRepo) {
        this.compraRepo = compraRepo;
    }

    public List<Compra> listarCompras() {
        return compraRepo.findAll();
    }

    public Compra guardarCompra(Compra compra) {
        return compraRepo.save(compra);
    }
}
