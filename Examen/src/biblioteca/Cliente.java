package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente extends Persona implements ICliente{

	private LocalDate fechaSolicitud;
	private LocalDate fechaEntrega;
	private String estado;
	private Libro libro;
	
	public Cliente(String dni, LocalDate fechaSolicitud, LocalDate fechaEntrega, String estado, Libro libro) {
		super(dni);
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.libro = libro;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public Integer diasAtraso() {
		// TODO Auto-generated method stub
		return (int) ChronoUnit.DAYS.between(fechaEntrega, LocalDate.now());
	}

	@Override
	public Estado estadoPrestamo() {
		if(this.diasAtraso()<=10) {
			return Estado.EN_REGLA;
		}
		return Estado.VENCIDO;
	}

	@Override
	public Integer dineroAdeudado() {
		Integer dinero = 0;
		if(this.diasAtraso()>10) {
			dinero = this.diasAtraso()-10;
		}
		return dinero;
	}

	@Override
	public Boolean clienteMoroso() {
		// TODO Auto-generated method stub
		return this.estadoPrestamo().equals(Estado.VENCIDO);
	}

	@Override
	public String toString() {
		return "Cliente [fechaSolicitud=" + fechaSolicitud + ", fechaEntrega=" + fechaEntrega + ", estado=" + estado
				+ ", libro=" + libro + "]";
	}
	
	
	
}
