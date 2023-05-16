package controller;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;
import java.util.List;

import model.Vuelo;
import view.Vista;

public class Controlador {


	private Vista vista;
	
	public Controlador(Vista vista)
	{
		this.vista = vista;
	}
	
	public void abrirVista(List<Vuelo> vuelos) {

		vista.abrirVista(vuelos);
		for(Vuelo v: vuelos) {
			vista.mostrarInfo(v);
		}
		
	}
}
