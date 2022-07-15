package com.prueba.backend.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idCliente ;

    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;

    @Column(name = "apellidos", nullable = true, length = 45)
    private String apellidos;

    @Column(name = "cedula", nullable = true, length = 45)
    private String cedula;

    @Column(name = "tipoDocumento", nullable = true, length = 45)
    private String tipoDocumento;

    @Column(name = "telefono", nullable = true, length = 45)
    private String telefono;

    @Column(name = "correo", nullable = true, length = 45)
    private String correo;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<cuentasBancarias> cuentasBancarias;


    public cliente (){

    }

    public cliente(int idCliente, String nombre, String apellidos, String cedula, String tipoDocumento, String telefono, String correo) {

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.tipoDocumento = tipoDocumento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cedula='" + cedula + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
