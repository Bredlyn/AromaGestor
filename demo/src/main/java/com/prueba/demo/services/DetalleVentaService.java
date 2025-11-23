package com.prueba.demo.services;

import com.prueba.demo.document.DetalleVenta;
import com.prueba.demo.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> listar() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public void eliminar(String id) {
        detalleVentaRepository.deleteById(id);
    }
}
