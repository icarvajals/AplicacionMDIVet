package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Archivo;
import model.ArchivoUtil;
import view.PanelNuevo;
import view.VentanaPrincipal;

public class Controller implements ActionListener {

    private VentanaPrincipal ventp;
    private PanelNuevo panelNuevo;
    private ArchivoUtil file;
    private Archivo archivo;

    public Controller() {
        ventp = new VentanaPrincipal();
        file = new ArchivoUtil();
        archivo = new Archivo();
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
        ventp.getAnalizador().addActionListener(this);
        ventp.getCargar().addActionListener(this);
        ventp.getNuevo().addActionListener(this);
        ventp.getEditarDocumento().addActionListener(this);
    }
    private void asignarOyentesPanelNuevo(PanelNuevo pn) {
        pn.getBtnGuardar().addActionListener(this);
        pn.getBtnCancelar().addActionListener(this);
        pn.getBtnEditar().addActionListener(this);
        ventp.getEditarDocumento().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "SELECCIONAR_ARCHIVO":
                ventp.getPanelArchivo().setVisible(false);
                archivo = abrirArchivo();
                if (archivo != null) {
                    ventp.mostrarContenidoArchivo(archivo.getNombre(), archivo.getContenido());
                    ventp.getPanelResultados().getTxtTokens().setText("Token1\nToken2\nToken3");
                }
                break;
            case"ANALIZADOR_LÉXICO":
                ventp.getPanelVistaArchivo().setVisible(false);
                ventp.getPanelResultados().getTxtContenido().setText(archivo.getContenido());
                ventp.getPanelResultados().setVisible(true);
                break;

            case "ABRIR":
                Archivo archivo3 = abrirArchivo();
                if (archivo3 != null) {
                    archivo = archivo3;
                    ventp.mostrarContenidoArchivo(archivo.getNombre(), archivo.getContenido());
                    ventp.getPanelArchivo().setVisible(false);
                }
            break;

            case "NUEVO":
                crearDocumento();
            break;

            case "EDITAR":
                System.out.println(">> EDITAR presionado");
                if (archivo.getNombre() != null) {
                    System.out.println(">> Archivo a editar: " + archivo.getNombre());
                    System.out.println(">> Contenido: " + archivo.getContenido());

                    panelNuevo = new PanelNuevo(archivo.getNombre(), archivo.getContenido(), false);
                    asignarOyentesPanelNuevo(panelNuevo);
                    ventp.agregarDocumento(panelNuevo);
                } else {
                    System.out.println(">> archivo.getNombre() es null");
                }
                break;

            case "EDITAR2":
                if (panelNuevo != null) {
                    panelNuevo.mostrarModoEdicion(true);
                }
            break;
            case "GUARDAR":
                if (panelNuevo != null) {
                    String contenidoGuardado = panelNuevo.getTextArea().getText();

                    archivo.setContenido(contenidoGuardado);

                    panelNuevo.mostrarModoEdicion(false);

                    JOptionPane.showMessageDialog(ventp, "Documento guardado correctamente.");
                    ventp.getPanelResultados().getTxtContenido().setText(archivo.getContenido());
                }
                break;

            case "CANCELAR":
                if (panelNuevo != null) {
                    panelNuevo.getTextArea().setText(archivo.getContenido());
                    panelNuevo.mostrarModoEdicion(false);
                }
                break;


        }



    }
    public void crearDocumento() {
        String nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del documento (sin extensión)");

        if (nombreArchivo != null && !nombreArchivo.trim().isEmpty()) {
            if (!nombreArchivo.endsWith(".txt")) {
                nombreArchivo += ".txt";
            }
            panelNuevo = new PanelNuevo(nombreArchivo, "", true);
            asignarOyentesPanelNuevo(panelNuevo);
            ventp.agregarDocumento(panelNuevo);
        }
    }

    public Archivo abrirArchivo(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filtroTxt);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int result = fileChooser.showOpenDialog(ventp);

        if (result == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
            try {
                String contenido = file.obtenerContenido(archivoSeleccionado).getContenido();
                return new Archivo(archivoSeleccionado.getName(), contenido);
            } catch (IOException ex) {
                System.err.println("Error al leer el archivo: " + ex.getMessage());
            }
        }return null;
    }

}
