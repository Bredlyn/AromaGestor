package com.prueba.demo.services;


import com.prueba.demo.entity.DetalleCompra;
import com.prueba.demo.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleCompraService {
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    public List<DetalleCompra> listar() {
        return detalleCompraRepository.findAll();
    }

    public DetalleCompra guardar(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    public void eliminar(Long id) {
        detalleCompraRepository.deleteById(id);
    }
    @Autowired
    private ProductoService productoService;

    public void guardarCompra(DetalleCompra detalleCompra) {
        Long idProducto = detalleCompra.getProducto().getId();
        int cantidad = detalleCompra.getCantidad();
        productoService.agregarStock(idProducto, cantidad);
        detalleCompraRepository.save(detalleCompra);
    }


}