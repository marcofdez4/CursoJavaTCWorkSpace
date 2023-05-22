package examen;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado implements IEmpleado{

	private String nombre;
	private String apellido;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private Sexo sexo;
	private String ciudad;
	private Posicion posicion;
	private Double salarioBase;
	
	public Empleado(String nombre, String apellido, LocalDate fechaIngreso, LocalDate fechaSalida, Sexo sexo,
			String ciudad, Posicion posicion, Double salarioBase) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.posicion = posicion;
		this.salarioBase = salarioBase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Override
	public Double calcularSalario() {
		// TODO Auto-generated method stub
		return this.salarioBase*0.83;
	}

	@Override
	public Integer antiguedadLaboral() {
		// TODO Auto-generated method stub
		return (int) ChronoUnit.YEARS.between(this.fechaIngreso, LocalDate.now());
	}

	@Override
	public Rotacion rotacion() {
		Rotacion rotacion = null;
		if(this.posicion.equals(Posicion.INGENIERO)&&this.antiguedadLaboral()>2) {
			rotacion = Rotacion.HABILITADA;
		}
		else if(this.posicion.equals(Posicion.INGENIERO)&&this.antiguedadLaboral()<2) {
			rotacion = Rotacion.NO_HABILITADA;
		}
		else {
			rotacion = Rotacion.POR_DEFINIR;
		}
		
		return rotacion;
	}
	
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", fechaIngreso=" + fechaIngreso
				+ ", fechaSalida=" + fechaSalida + ", sexo=" + sexo + ", ciudad=" + ciudad + ", posicion=" + posicion
				+ ", salarioBase=" + salarioBase + "]";
	}
	
}
