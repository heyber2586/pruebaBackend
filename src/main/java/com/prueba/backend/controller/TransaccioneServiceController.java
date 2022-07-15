package com.prueba.backend.controller;

import com.prueba.backend.interfaces.InterfaceTransacciones;
import com.prueba.backend.model.cliente;
import com.prueba.backend.model.transacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/transaccionService")
public class TransaccioneServiceController {

    @Autowired
    private InterfaceTransacciones interfaceTransacciones;


    @GetMapping("/listar")
    public ResponseEntity<List<transacciones>> getTransaccion(){
        List<transacciones> clienTransa = interfaceTransacciones.findAll();
        return ResponseEntity.ok(clienTransa);
    }

    @PostMapping("/registro")
    public ResponseEntity<transacciones> registroTransaccion(@RequestBody transacciones datoTransacciones){

        transacciones transaccionesInsert = interfaceTransacciones.save(datoTransacciones);
        return new ResponseEntity<transacciones>(datoTransacciones, HttpStatus.OK);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<transacciones> actualizarTransaccion(@RequestBody transacciones datoTransacciones, @PathVariable int id){
        java.util.Optional<transacciones> updateTransacc= interfaceTransacciones.findById(datoTransacciones.getIdTransaccion());
        if (updateTransacc.isPresent()) {
            transacciones newTran = updateTransacc.get();
            newTran.setMontoTransaccion(datoTransacciones.getMontoTransaccion());
            newTran.setNumerocuenta(datoTransacciones.getNumerocuenta());

            interfaceTransacciones.save(newTran);

            return ResponseEntity.ok(newTran);

        } else {
            return ResponseEntity.noContent().build();
        }

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody transacciones transacciones, @PathVariable Integer id) {
        try {
            Optional<transacciones> existClient = interfaceTransacciones.findById(transacciones.getIdTransaccion());
            interfaceTransacciones.save(transacciones);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deleteTransaccion(@PathVariable int id) {
        interfaceTransacciones.deleteById(id);
    }
}
