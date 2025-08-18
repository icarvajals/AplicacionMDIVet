package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import model.Archivo;
import model.ArchivoUtil;
import view.VentanaPrincipal;

public class Controller {

    private VentanaPrincipal ventp;

    public Controller() {
        ventp = new VentanaPrincipal();
        funcionar();
    }

    private void funcionar() {
        ventp.setVisible(true);

        ventp.getCargar().addActionListener(e -> {
            ventp.getPanelArchivo().setVisible(true);
        });

    }

    public void leerArchivo(Archivo archivo) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa la ruta del archivo .txt: ");
        String ruta = sc.nextLine();

        File file = new File(ruta);
        ArchivoUtil util = new ArchivoUtil();

        try {
            Archivo archivo1 = util.obtenerContenido(file);
            System.out.println("Nombre del archivo: " + archivo1.getNombre());
            System.out.println("Contenido del archivo:\n" + archivo1.getContenido());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Archivo inválido: " + e.getMessage());
        }

        sc.close();

    }

}
