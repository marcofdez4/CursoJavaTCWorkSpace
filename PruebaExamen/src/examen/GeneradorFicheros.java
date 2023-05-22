package examen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class GeneradorFicheros {

	public static void main(String[] args) {
		Empleado e1 = new Empleado("Marco", "Fernandez", LocalDate.of(2020, 2, 28), LocalDate.of(2023, 2, 28), Sexo.HOMBRE, "Sevilla", Posicion.INGENIERO, 17583.21);
		Empleado e2 = new Empleado("Pablo", "Calle", LocalDate.of(2021, 2, 28), null, Sexo.HOMBRE, "Utrera", Posicion.INGENIERO, 19583.21);
		Empleado e3 = new Empleado("Miguel", "Reyes", LocalDate.of(2023, 2, 28), LocalDate.of(2022, 2, 28), Sexo.HOMBRE, "Granada", Posicion.INGENIERO, 16583.21);
		Empleado e4 = new Empleado("Juan", "Perez", LocalDate.of(2020, 2, 28), LocalDate.of(2023, 2, 28), Sexo.HOMBRE, "Madrid", Posicion.OTROS, 27583.21);
		
		List<Empleado> empleados = Arrays.asList(e1, e2, e3, e4);
		
		try {
			String rutaSalida = "src\\examen\\infoEmpleados.txt";
			File archivoSalida = new File(rutaSalida);

			if (!archivoSalida.exists()) {
				archivoSalida.createNewFile();
			}
			
			FileWriter fw = new FileWriter(archivoSalida);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("PROGRAMA DE Empleados\n");
			for(Empleado e: empleados) {
				System.out.println("\nNombre del empleado "+e.getNombre());
				System.out.println("\nApellidos:  "+e.getApellido());
				System.out.println("\nFecha de ingreso:  "+e.getFechaIngreso().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				String fechaSalida = e.getFechaSalida()==null?"no procede":e.getFechaSalida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("\nFecha de salida:  "+fechaSalida);
				System.out.println("\nSexo:  "+e.getSexo().toString());
				System.out.println("\nCiudad:  "+e.getCiudad());
				System.out.println("\nPosicion:  "+e.getPosicion().toString());
				System.out.println("\nSalario base:  "+e.getSalarioBase());
				System.out.println("\nSalario final:  "+e.calcularSalario());
				System.out.println("\nAntiguedad laboral:  "+e.antiguedadLaboral());
				System.out.println("\nRotacion:  "+e.rotacion().toString());
				System.out.println("\n----------------------------------------------------------------\n");
				
			}
			
			ObjectMapper objMap = new ObjectMapper();
			objMap.findAndRegisterModules();
			String json = objMap.writeValueAsString(empleados);
			bw.write(json);
			bw.close();
			System.out.println("Programa finalizado con exito, tenga un buen dia");
		}
		catch(Exception e) {
			System.out.println("Ups! error inesperado\n"+e.getMessage());
		}
	}
}
