package com.prueba.demo.repository;

import com.prueba.demo.document.DetalleVenta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleVentaRepository extends MongoRepository<DetalleVenta, String> {

}
