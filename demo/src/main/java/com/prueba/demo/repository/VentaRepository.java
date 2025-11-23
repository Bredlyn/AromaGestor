package com.prueba.demo.repository;

import com.prueba.demo.document.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VentaRepository extends MongoRepository<Venta, String> {
}
