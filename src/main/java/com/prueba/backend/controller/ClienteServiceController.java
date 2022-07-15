package com.prueba.backend.controller;


import com.prueba.backend.interfaces.InterfaceCliente;
import com.prueba.backend.model.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/clientService")
public class ClienteServiceController {

    @Autowired
    private InterfaceCliente interfaceCliente;


    @GetMapping("/listar")
    public ResponseEntity<List<cliente>>getCliente(){
        List<cliente> clientDatos = interfaceCliente.findAll();
        return ResponseEntity.ok(clientDatos);
    }

    @PostMapping("/registro")
    public ResponseEntity<cliente> registroCliente(@RequestBody cliente datosCliente){

        cliente clienteInsert = interfaceCliente.save(datosCliente);
        return new ResponseEntity<cliente>(datosCliente, HttpStatus.OK);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<cliente> actualizarCliente( @RequestBody cliente datosCliente, @PathVariable int id){
        java.util.Optional<cliente> updateCliente= interfaceCliente.findById(datosCliente.getIdCliente());
        if (updateCliente.isPresent()) {
           cliente newCliente = updateCliente.get();
           newCliente.setNombre(datosCliente.getNombre());
           newCliente.setApellidos(datosCliente.getApellidos());
           newCliente.setCedula(datosCliente.getCedula());
           newCliente.setTipoDocumento(datosCliente.getTipoDocumento());
           newCliente.setTelefono(datosCliente.getTelefono());
           newCliente.setCorreo(datosCliente.getCorreo());
           interfaceCliente.save(newCliente);

           return ResponseEntity.ok(newCliente);

        } else {
            return ResponseEntity.noContent().build();
        }

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody cliente cliente, @PathVariable Integer id) {
        try {
            Optional<cliente> existClient = interfaceCliente.findById(cliente.getIdCliente());
            interfaceCliente.save(cliente);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable int id) {
        interfaceCliente.deleteById(id);
    }

}
