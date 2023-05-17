package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre;
	private String apellido;
	private String ciudad;
	private String email;
	private String salario;
	private LocalDate fechaNacimiento;
	private String contrasena;
	
	private List<Producto> listaProductos;

	public Cliente(String nombre, String apellido, String ciudad, String email, String salario,
			LocalDate fechaNacimiento, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.email = email;
		this.salario = salario;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.listaProductos = new ArrayList<>();
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
}
