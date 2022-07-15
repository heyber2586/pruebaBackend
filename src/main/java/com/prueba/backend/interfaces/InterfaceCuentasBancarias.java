package com.prueba.backend.interfaces;

import com.prueba.backend.model.cuentasBancarias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceCuentasBancarias extends JpaRepository<cuentasBancarias, Integer> {
}
