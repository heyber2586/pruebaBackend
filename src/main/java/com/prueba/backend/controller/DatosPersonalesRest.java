package com.prueba.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.backend.model.cuentasBancarias;
import com.prueba.backend.interfaces.InterfacePersona;

//aca tenemos nuestro controlador de la aplicacion
//con la anotacion restcontroller para tener un servicio rest
//la anotacion crosorigin para que no genere error al ser
//consumida al ser restringido por estar fuera del dominio donde se comsume el api rest
@RestController
@RequestMapping("/apiBackend")
@CrossOrigin({"*"})
public class DatosPersonalesRest {
	
	//se inyecta la interfaz de persona donde tenemos los metodos del crud para ser usados en cada servicio rest
	//si se necesitan crear metodos mas complejos podemos crear una interfaz que consuma herede los metodos de jpa y llegar a modificarlos
	//y usar una clase para implementarlos
	@Autowired
	private InterfacePersona interfacePersona;

	//metododo para listar todos los datos de nuestra entidad
	@GetMapping("/listar")
	public ResponseEntity<List<cuentasBancarias>>getDatosPersonles(){
		List<cuentasBancarias> datos  = interfacePersona.findAll();
		return ResponseEntity.ok(datos);	
	}
	//metodo de guardar un objeto de tipo datos personales que hemos casteado a datos con requestbody lo convertimos
	@PostMapping(value="/registro")
	public ResponseEntity<cuentasBancarias> save(@RequestBody cuentasBancarias datos){
		
		cuentasBancarias datosInsert = interfacePersona.save(datos);
		return new ResponseEntity<cuentasBancarias>(datosInsert, HttpStatus.OK);
	}
	
	/*@PutMapping("/actualizar")
	public ResponseEntity<cuentasBancarias> actualizarDatos(@RequestBody cuentasBancarias datos){
		java.util.Optional<cuentasBancarias> updateProducto = interfacePersona.findById(datos.getId());
		if (updateProducto.isPresent()) {	
			cuentasBancarias newDatos = updateProducto.get();
			newDatos.setNombre(datos.getNombre());
			newDatos.setApellido(datos.getApellido());
			newDatos.setProcesado(datos.isProcesado());
			interfacePersona.save(newDatos);
			
			return ResponseEntity.ok(newDatos);
		} else {
			return ResponseEntity.noContent().build();		
			
		}
	}*/
  
    
  }
