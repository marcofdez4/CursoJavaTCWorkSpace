package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Programa {
	public static void main(String[] args) {
		String barcelona = "https://api.open-meteo.com/v1/forecast?latitude=41.39&longitude=2.16&hourly=temperature_2m&current_weather=true&forecast_days=1";
		String buenosAires = "https://api.open-meteo.com/v1/forecast?latitude=-34.61&longitude=-58.38&hourly=temperature_2m&current_weather=true&forecast_days=1";
		String madrid = "https://api.open-meteo.com/v1/forecast?latitude=40.42&longitude=-3.70&hourly=temperature_2m&current_weather=true&forecast_days=1";
		String berlin = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m&current_weather=true&forecast_days=1";

		Ciudad c1 = new Ciudad("Barcelona", barcelona);
		Ciudad c2 = new Ciudad("Buenos Aires", buenosAires);
		Ciudad c3 = new Ciudad("Madrid", madrid);
		Ciudad c4 = new Ciudad("Berlin", berlin);
		List<Ciudad> ciudades = Arrays.asList(c1, c2, c3, c4);
		for (Ciudad ciudad : ciudades) {
			try {
				URL endpoint = new URL(ciudad.getUrl());
				HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
				con.connect();
				int tiempoDeRespuesta = con.getResponseCode();
				if (tiempoDeRespuesta != 200) {
					throw new RuntimeException("HttpResponseCode" + tiempoDeRespuesta);
				} else {
					InputStreamReader input = new InputStreamReader(con.getInputStream());

					Gson datag = new Gson();
					JsonElement datae = datag.fromJson(input, JsonElement.class);
					JsonObject data = datae.getAsJsonObject();

					

					List<JsonElement> timeList = data.get("hourly").getAsJsonObject().get("time").getAsJsonArray()
							.asList();
					
					System.out.println("Tiempo para "+ciudad.getNombre());
					int i = 0;
					for(JsonElement je: timeList) {
						i++;
						LocalDateTime fe = LocalDateTime.now();
						Integer horaActual = fe.getHour();
						String[] horaMin = je.getAsString().split("T");
						String horaSt = horaMin[1].split(":")[0];
						Integer hora = Integer.valueOf(horaSt);
						if(horaActual.equals(hora)) {
							System.out.println("A las "+horaMin[1]);
							break;
						}
					}
					
					List<JsonElement> temperaturaList = data.get("hourly").getAsJsonObject().get("temperature_2m").getAsJsonArray()
							.asList();
					
					Double temperatura = temperaturaList.get(i).getAsDouble();
					System.out.println("La temperatura sera de "+temperatura+" ºC");
					if(temperatura>10) {
						System.out.println("Recomendamos que use ropa fresca");
					}
					else {
						System.out.println("Recomendamos que use ropa abrigada");
					}
					
					System.out.println("--------------------------------------------------");

				}
			} catch (Exception e) {
				System.out.println("Oops! hubo una excepción");
			}
		}
		System.out.println("Programa finalizado con exito, tenga un buen dia");
	}
}
