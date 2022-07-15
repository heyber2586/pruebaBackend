package com.prueba.backend.interfaces;

import com.prueba.backend.model.transacciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceTransacciones extends JpaRepository<transacciones, Integer>{
}
