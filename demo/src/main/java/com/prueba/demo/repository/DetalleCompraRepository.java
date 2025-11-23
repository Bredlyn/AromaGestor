package com.prueba.demo.repository;

import com.prueba.demo.document.DetalleCompra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleCompraRepository extends MongoRepository<DetalleCompra, String> {

}
