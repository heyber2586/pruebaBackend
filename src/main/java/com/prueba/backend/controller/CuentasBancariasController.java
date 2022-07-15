package com.prueba.backend.controller;

import com.prueba.backend.interfaces.InterfaceCliente;
import com.prueba.backend.interfaces.InterfaceCuentasBancarias;
import com.prueba.backend.interfaces.InterfaceTransacciones;
import com.prueba.backend.model.cuentasBancarias;
import com.prueba.backend.model.transacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/cuentasService")
public class CuentasBancariasController {

    @Autowired
    private InterfaceCuentasBancarias interfaceCuentasBancarias;

    @Autowired
    private InterfaceCliente interfaceCliente;

    @GetMapping("/listar")
    public ResponseEntity<List<cuentasBancarias>> getCuenta(){
        List<cuentasBancarias> cuentaBancaria = interfaceCuentasBancarias.findAll();
        return ResponseEntity.ok(cuentaBancaria);
    }

    @PostMapping("/registro")
    public ResponseEntity<cuentasBancarias> registroTransaccion(@RequestBody cuentasBancarias datoCuenta){

        cuentasBancarias transaccionesInsert = interfaceCuentasBancarias.save(datoCuenta);
        return new ResponseEntity<cuentasBancarias>(datoCuenta, HttpStatus.OK);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<cuentasBancarias> actualizarCuenta(@RequestBody cuentasBancarias dataCuenta, @PathVariable int id){
        java.util.Optional<cuentasBancarias> updateCuenta= interfaceCuentasBancarias.findById(dataCuenta.getIdCuentasBancarias());
        if (updateCuenta.isPresent()) {
            cuentasBancarias newCuenta = updateCuenta.get();
            newCuenta.setMoneda(dataCuenta.getMoneda());
            newCuenta.setNumerocuenta(dataCuenta.getNumerocuenta());
            newCuenta.setTipoDeCuenta(dataCuenta.getTipoDeCuenta());

            interfaceCuentasBancarias.save(newCuenta);

            return ResponseEntity.ok(newCuenta);

        } else {
            return ResponseEntity.noContent().build();
        }

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody cuentasBancarias cuentasBancarias, @PathVariable Integer id) {
        try {
            Optional<cuentasBancarias> existClient = interfaceCuentasBancarias.findById(cuentasBancarias.getIdCuentasBancarias());
            interfaceCuentasBancarias.save(cuentasBancarias);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCuenta(@PathVariable int id) {
        interfaceCuentasBancarias.deleteById(id);
    }
}
