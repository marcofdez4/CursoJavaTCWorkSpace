package model;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;

public class Vuelo {

	private String nombre;
	private String origen;
	private String destino;
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;
	
	public Vuelo(String nombre, String origen, String destino, LocalDateTime fechaSalida, LocalDateTime fechaLlegada) {
		super();
		this.nombre = nombre;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public Long duracionDias() {
		return DAYS.between(this.getFechaSalida(), this.getFechaLlegada());
	}

	
}
