package com.prueba.backend.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.backend.model.cuentasBancarias;

// estamos heradando los metodos de jparepository el crud, se pueden usar metodos mas completos que los de crudrepository
//donde recibe un objeto y el tipo de id, en este caso un objeto de tipo datos y el id de tipo integer
// importamos nuestra entidad que la pasaremos a jparepository
public interface InterfacePersona extends JpaRepository<cuentasBancarias, Integer>{


}
