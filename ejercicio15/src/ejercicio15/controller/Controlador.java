package ejercicio15.controller;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejercicio15.model.Usuario;
import ejercicio15.view.Vista;

public class Controlador {
	
	private Vista vista;
	
	public Controlador(Vista vista)
	{
		this.vista = vista;
	}
	
	public void ingresarUsuarios()
	{
		Scanner sc = new Scanner(System.in);
		List<Usuario> users = new ArrayList<>();
		
		int menu = 99;
		while(menu!=0) {
			System.out
			.println("Ingrese una operacion:\n" + "1. Registrar usuario\n" +"2. Ver lista de usuarios\n"+ "0. Salir");
			
			menu = sc.nextInt();
			switch (menu) {
			case 0:
				sc.close();
				break;
			case 1:
				Usuario addUser = registraUsuario(sc);
				users.add(addUser);
				vista.mostrarInfo(addUser);
				break;
			case 2:
				if(users.isEmpty()) {
					System.out.println("La lista esta vacía!");
				}
				else {
					System.out.println("La lista de usuarios es:");
					for(Usuario u: users) {
						System.out.println(u.getUsername());
					}
				}
				break;
			default:
				System.out.println("numero erroneo, inserte otro numero de la lista");
			}	
			System.out.println("-------------------------------------------------");
		}
		System.out.println("Que pase un buen dia");	
	}
	
	public static Usuario registraUsuario(Scanner sc) {
		System.out.println("Ingresando usuario...");
		System.out.println("Nombre: ");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Apellido: ");
		String apellido = sc.nextLine();
		System.out.println("Correo electronico: ");
		String correo = sc.nextLine();
		System.out.println("nombre usuario: ");
		String username = sc.nextLine();
		
		return new Usuario(nombre, apellido, correo, username);
		
		

	}
	
}
