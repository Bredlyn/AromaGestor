package com.prueba.demo.repository;

import com.prueba.demo.document.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompraRepository extends MongoRepository<Compra, String> {
}
