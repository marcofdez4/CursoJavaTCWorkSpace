package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Cliente;
import model.Producto;

public class Vista {

	public void principal(List<Cliente> clientes) {
		JFrame ventanaPrincipal = new JFrame();
		ventanaPrincipal.setTitle("Homebanking");
		ventanaPrincipal.setSize(650,300);
		ventanaPrincipal.setLayout(null);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel texto = new JLabel("\"Bienvenid@ a nuestra aplicación de Homebanking, si ya sos usuario por favor logueate, sino, registrate\" ");
		texto.setBounds(10,10,900,30);
		ventanaPrincipal.add(texto);
		JButton abrirLogin = new JButton("Login");
		abrirLogin.setBounds(275,70,90,30);
		abrirLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						login(clientes);
					}
			
				});
		ventanaPrincipal.add(abrirLogin);
		
		JButton abrirRegistro = new JButton("Registro");
		abrirRegistro.setBounds(275,120,90,30);
		abrirRegistro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						registro(clientes);
					}
			
				});
		ventanaPrincipal.add(abrirRegistro);
		ImageIcon icon = new ImageIcon("icons.png");
		ventanaPrincipal.setIconImage(icon.getImage());
		ventanaPrincipal.setVisible(true);
	}
	
	public void login(List<Cliente> clientes) {
		JFrame login = new JFrame();
		login.setTitle("Login");
		login.setSize(500,300);
		login.setLayout(null);
		login.setVisible(true);
		JLabel correoLabel = new JLabel("Correo: ");
		correoLabel.setBounds(150,50,90,30);
		JTextField correo = new JTextField();
		correo.setBounds(250,50,200,30);
		JLabel contraseniaLabel = new JLabel("Contraseña: ");
		contraseniaLabel.setBounds(150,100,90,30);
		JPasswordField contrasena = new JPasswordField();
		contrasena.setBounds(250,100,200,30);
		
		JButton abrirLogin = new JButton("Login");
		abrirLogin.setBounds(200,200,90,30);
		abrirLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						String correoText = correo.getText();
						String contrasenaText = contrasena.getText();
						Boolean loginCorrecto = Boolean.FALSE;
						for(Cliente c: clientes) {
							if(c.getEmail().equals(correoText)) {
								if(c.getContrasena().equals(contrasenaText)) {
									productos(c);
									loginCorrecto = Boolean.TRUE;
									break;
								}
								else {
									break;
								}
							}
						}
						if(!loginCorrecto) {
							loginIncorrecto();
						}
					}
			
				});
		login.add(correoLabel);
		login.add(contraseniaLabel);
		login.add(correo);
		login.add(contrasena);
		login.add(abrirLogin);
	}
	
	public void registro(List<Cliente> clientes) {
		JFrame registro = new JFrame();
		registro.setTitle("Registro");
		registro.setSize(500,400);
		registro.setLayout(null);
		registro.setVisible(true);
		
		//nombre
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(25,20,90,30);
		JTextField nombre = new JTextField();
		nombre.setBounds(250,20,200,30);
		//apellido
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(25,60,90,30);
		JTextField apellido = new JTextField();
		apellido.setBounds(250,60,200,30);
		//ciudad
		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(25,100,90,30);
		JTextField ciudad = new JTextField();
		ciudad.setBounds(250,100,200,30);
		//correo
		JLabel correoLabel = new JLabel("Correo: ");
		correoLabel.setBounds(25,140,90,30);
		JTextField correo = new JTextField();
		correo.setBounds(250,140,200,30);
		//salario
		JLabel salarioLabel = new JLabel("Salario: ");
		salarioLabel.setBounds(25,180,90,30);
		JTextField salario = new JTextField();
		salario.setBounds(250,180,200,30);
		//fechaNacimiento
		JLabel nacimientoLabel = new JLabel("Fecha de nacimiento (dd-MM-YYYY): ");
		nacimientoLabel.setBounds(25,220,250,30);
		JTextField nacimiento = new JTextField();
		nacimiento.setBounds(250,220,200,30);
		//contrasena
		JLabel contraseniaLabel = new JLabel("Contraseña: ");
		contraseniaLabel.setBounds(25,260,90,30);
		JPasswordField contrasena = new JPasswordField();
		contrasena.setBounds(250,260,200,30);
		
		JButton abrirRegistro = new JButton("Registrarse");
		abrirRegistro.setBounds(200,320,90,30);
		abrirRegistro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						String nombreText = nombre.getText();
						String apellidoText = apellido.getText();
						String ciudadText = ciudad.getText();
						String correoText = correo.getText();
						String salarioText = salario.getText();
						String fechaText = nacimiento.getText();
						String contrasenaText = contrasena.getText();
						
						if(nombreText.isEmpty() || apellidoText.isEmpty() || ciudadText.isEmpty()
								|| correoText.isEmpty() || salarioText.isEmpty() || contrasenaText.isEmpty()) {
							JFrame fail = new JFrame();
							fail.setTitle("Registro incorrecto incorrecto");
							fail.setSize(300,100);
							fail.setLayout(null);
							JLabel texto = new JLabel("Registro incorrecto, rellena todos los campos");
							texto.setBounds(10,10,300,30);
							fail.add(texto);
							fail.setVisible(true);
						}
						else {
							try {
								String[] fec = fechaText.split("-");
								LocalDate nacimi = LocalDate.of(Integer.valueOf(fec[2]), Integer.valueOf(fec[1]), Integer.valueOf(fec[0]));
								Double salarioD = Double.valueOf(salarioText);
								Cliente client = new Cliente(nombreText, apellidoText, ciudadText, correoText, salarioD, nacimi, contrasenaText);
								clientes.add(client);
								System.out.println("Te has registrado con exito!");
								productos(client);
								
							} catch (Exception ex) {
								JFrame fail2 = new JFrame();
								fail2.setTitle("Registro incorrecto incorrecto");
								fail2.setSize(400,100);
								fail2.setLayout(null);
								JLabel texto2 = new JLabel("Registro incorrecto, rellena la fecha bien o el salario bien");
								texto2.setBounds(10,10,400,30);
								fail2.add(texto2);
								fail2.setVisible(true);
							}
							
						}

					}
			
				});
		registro.add(nombreLabel);
		registro.add(apellidoLabel);
		registro.add(ciudadLabel);
		registro.add(correoLabel);
		registro.add(salarioLabel);
		registro.add(nacimientoLabel);
		registro.add(contraseniaLabel);
		
		registro.add(nombre);
		registro.add(apellido);
		registro.add(ciudad);
		registro.add(correo);
		registro.add(salario);
		registro.add(nacimiento);
		registro.add(contrasena);
		
		registro.add(abrirRegistro);
	}
	
	public void productos(Cliente cliente) {
		JFrame ventanaPrincipal = new JFrame();
		ventanaPrincipal.setTitle("Productos");
		ventanaPrincipal.setSize(800,500);
		ventanaPrincipal.setLayout(null);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel texto = new JLabel("Bienvenido, "+cliente.getNombre()+"!");
		texto.setBounds(10,10,900,30);
		ventanaPrincipal.add(texto);
		
		for(int i=1;i<=cliente.getListaProductos().size();i++) {
			Producto p = cliente.getListaProductos().get(i-1);
			JLabel product = new JLabel(p.getNombreProducto()+": dinero actual: "+p.getDinero()+"€ dinero gastado:"+p.getPlataGastada()+"€ Fecha de vencimiento: "+p.getFechaVencimiento());
			product.setBounds(10,40*i,600,30);

			ventanaPrincipal.add(product);
		}
		ventanaPrincipal.setVisible(true);
	}
	
	public void loginIncorrecto() {
		JFrame fail = new JFrame();
		fail.setTitle("Login incorrecto");
		fail.setSize(300,100);
		fail.setLayout(null);
		JLabel texto = new JLabel("Login incorrecto, vuelva a intentarlo");
		texto.setBounds(10,10,300,30);
		fail.add(texto);
		fail.setVisible(true);
	}
}
