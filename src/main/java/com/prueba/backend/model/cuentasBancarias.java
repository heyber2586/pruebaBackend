package com.prueba.backend.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cuentasBancarias")
public class cuentasBancarias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuentasBancarias;

	@Column(name = "moneda", nullable = false, length= 30)
	private int moneda;

	@Column(name = "numerocuenta", nullable = false, length = 30)
	private String numerocuenta;

	@Column(name = "tipoDeCuenta", nullable = false, length = 30 )
	private String tipoDeCuenta ;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "cuentasBancarias")
	private List<transacciones> transacciones;

    @ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false, updatable = false)
	private cliente cliente;




	public cuentasBancarias() {
		
	}

	public cuentasBancarias(int idCuentasBancarias, int moneda, String numerocuenta, String tipoDeCuenta, com.prueba.backend.model.cliente cliente) {
		this.idCuentasBancarias = idCuentasBancarias;
		this.moneda = moneda;
		this.numerocuenta = numerocuenta;
		this.tipoDeCuenta = tipoDeCuenta;
		this.cliente = cliente;
	}

	public int getIdCuentasBancarias() {
		return idCuentasBancarias;
	}

	public void setIdCuentasBancarias(int idCuentasBancarias) {
		this.idCuentasBancarias = idCuentasBancarias;
	}

	public int getMoneda() {
		return moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public String getNumerocuenta() {
		return numerocuenta;
	}

	public void setNumerocuenta(String numerocuenta) {
		this.numerocuenta = numerocuenta;
	}

	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}

	public com.prueba.backend.model.cliente getCliente() {
		return cliente;
	}

	public void setCliente(com.prueba.backend.model.cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "cuentasBancarias{" +
				"idCuentasBancarias=" + idCuentasBancarias +
				", moneda=" + moneda +
				", numerocuenta='" + numerocuenta + '\'' +
				", tipoDeCuenta='" + tipoDeCuenta + '\'' +
				", cliente=" + cliente +
				'}';
	}
}
