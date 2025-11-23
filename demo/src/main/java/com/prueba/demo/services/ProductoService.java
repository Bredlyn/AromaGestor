package com.prueba.demo.services;

import com.prueba.demo.document.Producto;
import com.prueba.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminar(String id) {
        productoRepository.deleteById(id);
    }

    public Producto buscarPorId(String id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto obtenerProductoPorId(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void agregarStock(String idProducto, int cantidad) {
        Producto producto = obtenerProductoPorId(idProducto);
        if (producto != null) {
            producto.setStock(producto.getStock() + cantidad);
            productoRepository.save(producto);
        }
    }

    public void reducirStock(String productoId, int cantidad) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }

        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);
    }
}
