package ejercicio15.view;

import ejercicio15.model.Usuario;

public class Vista {

	public void mostrarInfo(Usuario usuario)
	{
		System.out.println("Bienvenido " + usuario.getNombre() + " " + usuario.getApellido());
		System.out.println("Correo electronico: " + usuario.getCorreo());
		System.out.println("Nombre de usuario: " + usuario.getUsername());
	}
}
