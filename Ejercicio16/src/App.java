import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import controller.Controlador;
import model.Vuelo;
import view.Vista;

public class App {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Vuelo v1 = new Vuelo("Caribe", "Sevilla", "Tortuga", LocalDateTime.now().plusDays(10), LocalDateTime.now().plusDays(20));
		Vuelo v2 = new Vuelo("Hogwarts", "Madrid", "Callejon Diagon", LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(25));
		Vuelo v3 = new Vuelo("Tierra media", "Sevilla", "Mordor", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(200));
		List<Vuelo> vuelos = Arrays.asList(v1, v2, v3);
		Controlador controlador = new Controlador(vista);
		controlador.abrirVista(vuelos);
	}
}
