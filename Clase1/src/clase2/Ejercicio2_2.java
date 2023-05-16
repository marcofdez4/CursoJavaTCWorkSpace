package clase2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ejercicio2_2 {

	public static void main(String[] args) {
//		int[] numeros = {1,2,3,4,5,6,7,8,9,10};
//		LocalDate hoy = LocalDate.now();
//		LocalDate nacimiento = LocalDate.of(1999, 2, 28);
//		
//		int año = hoy.getYear() - nacimiento.getYear();
//		
//		String fecha = hoy.format(DateTimeFormatter.ofPattern("dd-MMM-YYYY"));
//		System.out.println(fecha);
		try {
			String ruta = "C:\\Users\\mafernandezgon\\Desktop\\workspace_eclipse\\Clase1\\src\\clase2";
			String nombreArchivo = "salida.txt";
			String nombreRutaArchivo = ruta + nombreArchivo;

			String contenidoEjemplo = "Hola jeje";

			File archivo = new File(nombreRutaArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			FileWriter fw= new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenidoEjemplo);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
