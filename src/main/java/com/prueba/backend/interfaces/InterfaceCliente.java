package com.prueba.backend.interfaces;

import com.prueba.backend.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceCliente extends JpaRepository<cliente,Integer> {
}
