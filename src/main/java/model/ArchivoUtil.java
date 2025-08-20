package model;

import view.VentanaPrincipal;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.List;

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

    public String crearDocumento() {
        String nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del documento (sin extensión)");
        if (nombreArchivo != null && !nombreArchivo.trim().isEmpty()) {
            if (!nombreArchivo.endsWith(".txt")) {
                nombreArchivo += ".txt";
            }
        }
        return nombreArchivo;
    }

    public void guardarArchivoEnDescargas(String nombreArchivo, List<String> contenido) {
        String userHome = System.getProperty("user.home");
        String carpetaDescargas = userHome + File.separator + "Downloads";

        File archivo = new File(carpetaDescargas, nombreArchivo);
        try {
            if (archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Ya existe el archivo en Descargas", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                for (String linea : contenido) {
                    salida.println(linea);
                }
                salida.close();
                JOptionPane.showMessageDialog(null, "Archivo creado en: " + archivo.getAbsolutePath());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el archivo", "Error", JOptionPane.ERROR_MESSAGE);
}
}
}