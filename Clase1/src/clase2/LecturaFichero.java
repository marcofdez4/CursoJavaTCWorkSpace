package clase2;

import java.io.File;
import java.util.Scanner;

public class LecturaFichero {

	public static void main(String[] args) {
		try {
			File f = new File("C:\\Users\\mafernandezgon\\Desktop\\workspace_eclipse\\Clase1\\src\\clase2\\clase2salida.txt");
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {

		}
	}
}
