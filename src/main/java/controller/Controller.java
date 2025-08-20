package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import model.Archivo;
import model.ArchivoUtil;
import model.Expresions_Regulars;
import view.VentanaPrincipal;

public class Controller implements ActionListener {

    private VentanaPrincipal ventp;
    private ArchivoUtil file;
    private Archivo archivo;
    private Expresions_Regulars expresionsRegulars;
    private String Creararchivo;

    public Controller() {
        ventp = new VentanaPrincipal();
        file = new ArchivoUtil();
        archivo = new Archivo();
        expresionsRegulars = new Expresions_Regulars();
        funcionar();
    }

    private void funcionar() {
        ventp.setVisible(true);
        asignarOyentes();
    }

    private void asignarOyentes() {
        ventp.getPanelArchivo().getBtnArchivo().addActionListener(this);
        ventp.getCargar().addActionListener(this);
        ventp.getNuevo().addActionListener(this);
        ventp.getPanelEditor().getBtnEjecutarLexer().addActionListener(this);
        ventp.getPanelEditor().getBtnEditar().addActionListener(this);
        ventp.getGarchivo().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "ABRIR":
                ventp.getPanelArchivo().setVisible(true);
                break;

            case "SELECCIONAR_ARCHIVO":
                archivo = file.abrirArchivo(ventp);
                if (archivo != null) {
                    ventp.getPanelArchivo().setVisible(false);
                    ventp.getPanelEditor().setVisible(true);
                    ventp.getPanelEditor().setVistaArchivo(archivo.getContenido());
                }
                break;
            case "NUEVO":
                Creararchivo = file.crearDocumento();
                if (Creararchivo != null){
                    ventp.getPanelEditor().setVisible(true);
                    JTextArea area = ventp.getPanelEditor().getVistaArchivo();
                    if (!area.isEditable()) {
                        // Entrar en modo edición
                        area.setEditable(true);
                        area.setBackground(Color.WHITE);
                        area.setForeground(Color.BLACK);
                        ventp.getPanelEditor().getBtnEditar().setText("Guardar");
                    } else {
                        // Guardar cambios
                        area.setEditable(false);
                        area.setBackground(new Color(240, 234, 230));
                        area.setForeground(Color.WHITE);

                        if (archivo != null) {
                            archivo.setContenido(area.getText()); // actualizar objeto archivo
                        }
                        ventp.getPanelEditor().getBtnEditar().setText("Editar");
                    }
                }
                break;

            case "CrearArchivo":
                if (archivo != null) {
                    List<String> lineas = Arrays.asList(archivo.getContenido().split("\n"));

                    file.guardarArchivoEnDescargas(Creararchivo, lineas);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay archivo cargado para guardar");
                }
                break;


            case "EJECUTAR_LEXER":
                if (archivo != null) {
                    String nuevoContenido = expresionsRegulars.validarExpresion(archivo.getContenido());
                    System.out.println(nuevoContenido);
                    ventp.getPanelEditor().setConsola(nuevoContenido);
                }
                break;
            case "EDITAR":
                if (ventp.getPanelEditor() != null) {
                    JTextArea area = ventp.getPanelEditor().getVistaArchivo();

                    if (!area.isEditable()) {
                        // Entrar en modo edición
                        area.setEditable(true);
                        area.setBackground(Color.WHITE);
                        area.setForeground(Color.BLACK);
                        ventp.getPanelEditor().getBtnEditar().setText("Guardar");
                    } else {
                        // Guardar cambios
                        area.setEditable(false);
                        area.setBackground(new Color(240, 234, 230));
                        area.setForeground(Color.WHITE);

                        if (archivo != null) {
                            archivo.setContenido(area.getText()); // actualizar objeto archivo
                        }

                        ventp.getPanelEditor().getBtnEditar().setText("Editar");
                    }
                }
                break;
 }
}
}