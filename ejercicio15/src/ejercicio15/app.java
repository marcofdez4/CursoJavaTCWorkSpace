package ejercicio15;

import ejercicio15.controller.Controlador;
import ejercicio15.view.Vista;

public class app {
	public static void main (String [] args)
	{
		
		Vista vista = new Vista();
		Controlador controlador = new Controlador(vista);
		controlador.ingresarUsuarios();
	}
}
