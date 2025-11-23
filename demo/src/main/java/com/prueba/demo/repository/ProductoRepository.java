package com.prueba.demo.repository;

import com.prueba.demo.document.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}
