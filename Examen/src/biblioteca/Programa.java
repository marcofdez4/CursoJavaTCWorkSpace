package biblioteca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		File f = new File("src\\biblioteca\\Biblioteca_Nacional_de_España.txt");
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				sc.nextLine();
				String nombreLibro = sc.nextLine();
				sc.nextLine();
				String autor = sc.nextLine();
				sc.nextLine();
				String[] fechaS = sc.nextLine().split("/");
				LocalDate fechaSolicitud = LocalDate.of(Integer.valueOf(fechaS[2]), Integer.valueOf(fechaS[1]), Integer.valueOf(fechaS[0]));
				
				sc.nextLine();
				String[] fechaE = sc.nextLine().split("/");
				LocalDate fechaEntrega = LocalDate.of(Integer.valueOf(fechaE[2]), Integer.valueOf(fechaE[1]), Integer.valueOf(fechaE[0]));
				sc.nextLine();
				String estado = sc.nextLine();
				sc.nextLine();
				String dni = sc.nextLine();
				Libro libro = new Libro(nombreLibro, autor);
				Cliente cliente = new Cliente(dni, fechaSolicitud, fechaEntrega, estado, libro);
				clientes.add(cliente);
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String rutaSalida = "src\\biblioteca\\inventario_y_vencimientos_fechaHoy.txt";
			File archivoSalida = new File(rutaSalida);

			if (!archivoSalida.exists()) {
				archivoSalida.createNewFile();
			}
			
			FileWriter fw = new FileWriter(archivoSalida);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("PROGRAMA DE BIBLIOTECA NACIONAL\n");
			bw.write("\n----------------------------------------------------------------\n");
			for(Cliente cli: clientes) {
				bw.write("\nInformacion del prestamo al cliente con dni '"+cli.getDni()+"'");
				bw.write("\nLibro: '"+cli.getLibro().getNombre()+"' escrito por '"+cli.getLibro().getAutor()+"'");
				bw.write("\nLa solicitud del prestamo fue el "+cli.getFechaSolicitud()+" y la fecha de entrega estipulada el "+cli.getFechaEntrega());
				bw.write("\nSu estado es: "+cli.getEstado());
				String diasAtraso = cli.diasAtraso()>0?cli.diasAtraso().toString():"no procede";
				bw.write("\nDias de atraso del cliente: "+diasAtraso);
				bw.write("\nEstado del prestamo: "+cli.estadoPrestamo().toString().replace("_", " "));
				bw.write("\nDinero adeudado: "+cli.dineroAdeudado());
				String clienteMoroso = cli.clienteMoroso()?"Si":"No";
				bw.write("\n¿Es el cliente moroso?: "+clienteMoroso);
				bw.write("\n----------------------------------------------------------------\n");
			}
			bw.close();
			System.out.println("Programa finalizado con exito, tenga un buen dia");
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
