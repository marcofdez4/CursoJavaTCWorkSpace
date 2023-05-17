package model;

import java.time.LocalDate;

public class Producto {

	private final Long NUMERO_TARJERA = 4444444444444444L;
	private Double dinero;
	private Double plataGastada;
	private String nombreProducto;
	private LocalDate fechaVencimiento;
	
	public Producto() {
		this.dinero = (double) Math.round(Math.random()*10000);
		this.plataGastada = (double) Math.round(Math.random()*1000);
		this.nombreProducto = "Tarjeta-"+(double) Math.round(Math.random()*10);
		this.fechaVencimiento = LocalDate.now().plusYears(4);
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public Long getNUMERO_TARJERA() {
		return NUMERO_TARJERA;
	}

	public Double getPlataGastada() {
		return plataGastada;
	}

	public void setPlataGastada(Double plataGastada) {
		this.plataGastada = plataGastada;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
	
}
