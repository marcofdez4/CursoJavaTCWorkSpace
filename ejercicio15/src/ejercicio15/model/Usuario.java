package ejercicio15.model;

public class Usuario {

	private String nombre;
	private String apellido;
	private String correo;
	private String username;
	
	public Usuario(String nombre, String apellido, String correo, String username) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.username = username;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
