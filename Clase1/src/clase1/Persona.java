package clase1;

public class Persona {

	private String nombre;
	private String apellido;
	private Integer edad;
	private Double altura;
	private String ciudad;
	
	
	
	
	public Persona() {
		super();
		this.nombre = null;
		this.apellido = null;
		this.edad = null;
		this.altura = null;
		this.ciudad = null;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
