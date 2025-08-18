package model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoUtil {

	public Archivo obtenerContenido(File file) throws IOException {
		if (file == null || !file.exists()) {
			throw new IllegalArgumentException("El archivo no puede ser nulo o vacío");
		}

		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				sb.append(linea).append("\n");
			}
		}
		String contenido = sb.toString();
		String nombreArchivo = file.getName();
		Archivo archivo = new Archivo(nombreArchivo, contenido);
		return archivo;
	}
}