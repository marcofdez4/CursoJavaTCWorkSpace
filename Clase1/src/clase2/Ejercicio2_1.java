package clase2;

import java.util.Scanner;

public class Ejercicio2_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out
				.println("Ingrese una operacion:\n" + "1. suma\n" + "2. resta\n" + "3. multiplicar\n" + "4. division");

		int menu = sc.nextInt();
		String menuAccion = "";
		int resultado = 0;
		System.out.println("Ingrese un numero:");
		int numero = sc.nextInt();
		System.out.println("Ingrese otro numero:");
		int numero1 = sc.nextInt();
		switch (menu) {
		case 1:
			resultado = numero + numero1;
			menuAccion = "suma";
			break;
		case 2:
			resultado = numero - numero1;
			menuAccion = "resta";
			break;
		case 3:
			resultado = numero * numero1;
			menuAccion = "multiplicacion";
			break;
		case 4:
			while (numero1 == 0) {
				System.out.println("no se puede dividir entre 0, pruebe otro numero: ");
				numero1 = sc.nextInt();
			}
			resultado = numero / numero1;
			menuAccion = "division";
			break;
		}
		System.out.println(
				"Tu resultado de la " + menuAccion + " de " + numero + " con " + numero1 + " es: " + resultado);
		sc.close();
	}
}
