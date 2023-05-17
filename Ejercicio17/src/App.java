import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.Controlador;
import model.Cliente;
import model.Producto;
import view.Vista;

public class App {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Controlador controlador = new Controlador(vista);
		List<Cliente> clientes = new ArrayList<>();
		Cliente admin = new Cliente("admin", "admin", "admin", "admin", 17000.02, LocalDate.now(), "admin");
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		Producto p3 = new Producto();
		List<Producto> productos = Arrays.asList(p1,p2,p3);
		admin.setListaProductos(productos);
		clientes.add(admin);
		
		controlador.abrirVista(clientes);
	}
}
