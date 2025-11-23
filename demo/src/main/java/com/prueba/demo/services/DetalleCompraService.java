package com.prueba.demo.services;

import com.prueba.demo.document.DetalleCompra;
import com.prueba.demo.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private ProductoService productoService;

    public List<DetalleCompra> listar() {
        return detalleCompraRepository.findAll();
    }

    public DetalleCompra guardar(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    public void eliminar(String id) {
        detalleCompraRepository.deleteById(id);
    }

    public void guardarCompra(DetalleCompra detalleCompra) {
        String idProducto = detalleCompra.getProductoId(); // <- CORREGIDO
        int cantidad = detalleCompra.getCantidad();
        productoService.agregarStock(idProducto, cantidad);
        detalleCompraRepository.save(detalleCompra);
    }
}
