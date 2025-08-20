package model;

import view.VentanaPrincipal;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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

    public Archivo abrirArchivo(VentanaPrincipal ventp){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filtroTxt);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int result = fileChooser.showOpenDialog(ventp);

        if (result == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
            try {
                String contenido = obtenerContenido(archivoSeleccionado).getContenido();
                return new Archivo(archivoSeleccionado.getName(), contenido);
            } catch (IOException ex) {
                System.err.println("Error al leer el archivo: " + ex.getMessage());
            }
        }return null;
    }

    public void crearDocumento() {
        String nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del documento (sin extensión)");
        if (nombreArchivo != null && !nombreArchivo.trim().isEmpty()) {
            if (!nombreArchivo.endsWith(".txt")) {
                nombreArchivo += ".txt";
            }
        }
    }
}