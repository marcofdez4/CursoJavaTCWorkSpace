package clase1;

public class Empleado extends Persona
{

	private String cargo;
	private Integer sueldo;
	
	public Empleado(String cargo, Integer sueldo) {
		super();
		this.cargo = cargo;
		this.sueldo = sueldo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Integer getSueldo() {
		return sueldo;
	}
	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	public static void main(String[] args) {
		Empleado e = new Empleado("informatico", 1500);
		e.setNombre("Marco");
		e.setApellido("fernz");
		e.setEdad(24);
		e.setAltura(1.86);
		e.setCiudad("Sevilla");
	}
}
