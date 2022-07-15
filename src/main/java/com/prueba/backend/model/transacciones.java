package com.prueba.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "transacciones")
public class transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccion;

    @Column(name = "montoTransaccion", nullable = false, length = 30)
    private String montoTransaccion;

    @Column(name = "numerocuenta", nullable = false, length = 30)
    private String numerocuenta;

    @ManyToOne
    @JoinColumn(name = "cuentaBancaria_id", nullable = false, updatable = false)
    private cuentasBancarias cuentasBancarias;

    public transacciones(){
        
    }

    public transacciones(int idTransaccion, String montoTransaccion, String numerocuenta, com.prueba.backend.model.cuentasBancarias cuentasBancarias) {
        this.idTransaccion = idTransaccion;
        this.montoTransaccion = montoTransaccion;
        this.numerocuenta = numerocuenta;
        this.cuentasBancarias = cuentasBancarias;
    }


    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(String montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public com.prueba.backend.model.cuentasBancarias getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(com.prueba.backend.model.cuentasBancarias cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    @Override
    public String toString() {
        return "transacciones{" +
                "idTransaccion=" + idTransaccion +
                ", montoTransaccion='" + montoTransaccion + '\'' +
                ", numerocuenta='" + numerocuenta + '\'' +
                ", cuentasBancarias=" + cuentasBancarias +
                '}';
    }
}
