package com.prueba.demo.repository;

import com.prueba.demo.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}