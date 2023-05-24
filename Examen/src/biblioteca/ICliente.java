package biblioteca;

public interface ICliente {

	Integer diasAtraso();
	
	Estado estadoPrestamo();
	
	Integer dineroAdeudado();
	
	Boolean clienteMoroso();
}
