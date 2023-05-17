package controller;

import java.util.List;

import model.Cliente;
import model.Producto;
import view.Vista;

public class Controlador {
	
	private Vista vista;
	
	public Controlador(Vista vista)
	{
		this.vista = vista;
	}
	
	public void abrirVista(List<Cliente> clientes) {

		vista.principal(clientes);
		
	}
}
