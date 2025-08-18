package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import model.Archivo;
import model.ArchivoUtil;
import view.VentanaPrincipal;

public class Controller implements ActionListener {

    private VentanaPrincipal ventp;
    private ArchivoUtil file;

    public Controller() {
        ventp = new VentanaPrincipal();
        file = new ArchivoUtil();
        funcionar();
    }

    private void funcionar() {
        ventp.setVisible(true);

        ventp.getCargar().addActionListener(e -> {
            ventp.getPanelArchivo().setVisible(true);
        });
        asignarOyentes();

    }

    private void asignarOyentes() {
        ventp.getPanelArchivo().getBtnArchivo().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "SELECCIONAR_ARCHIVO":
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(ventp);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
                    try {
                        file.obtenerContenido(archivoSeleccionado);
                        System.out.println(file.obtenerContenido(archivoSeleccionado));
                    } catch (IOException ex) {
                        System.err.println("Error al leer el archivo: " + ex.getMessage());
                    }
                }
        }

    }

}
