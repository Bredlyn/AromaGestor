package com.prueba.demo.repository;

import com.prueba.demo.document.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProveedorRepository extends MongoRepository<Proveedor, String> {

}
