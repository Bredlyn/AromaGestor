package com.prueba.demo.services;

import com.prueba.demo.entity.Venta;
import com.prueba.demo.repository.VentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public void guardarVenta(Venta venta) {
        ventaRepository.save(venta);
    }
}

