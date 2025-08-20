package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
                    file.crearDocumento();
                break;
            case "EJECUTAR_LEXER":
                if (archivo != null) {
                        String nuevoContenido = expresionsRegulars.validarExpresion(archivo.getContenido());
                        System.out.println(nuevoContenido);
                        ventp.getPanelEditor().setConsola(nuevoContenido);
                }
                break;
        }






//

//
//            case "EDITAR":
//                System.out.println(">> EDITAR presionado");
//                if (archivo.getNombre() != null) {
//                    System.out.println(">> Archivo a editar: " + archivo.getNombre());
//                    System.out.println(">> Contenido: " + archivo.getContenido());
//
//                    panelNuevo = new PanelNuevo(archivo.getNombre(), archivo.getContenido(), false);
//                    asignarOyentesPanelNuevo(panelNuevo);
//                    ventp.agregarDocumento(panelNuevo);
//                } else {
//                    System.out.println(">> archivo.getNombre() es null");
//                }
//                break;
//
//            case "EDITAR2":
//                if (panelNuevo != null) {
//                    panelNuevo.mostrarModoEdicion(true);
//                }
//            break;
//            case "GUARDAR":
//                if (panelNuevo != null) {
//                    String contenidoGuardado = panelNuevo.getTextArea().getText();
//
//                    archivo.setContenido(contenidoGuardado);
//
//                    panelNuevo.mostrarModoEdicion(false);
//
//                    JOptionPane.showMessageDialog(ventp, "Documento guardado correctamente.");
//                    ventp.getPanelResultados().getTxtContenido().setText(archivo.getContenido());
//                }
//                break;
//
//            case "CANCELAR":
//                if (panelNuevo != null) {
//                    panelNuevo.getTextArea().setText(archivo.getContenido());
//                    panelNuevo.mostrarModoEdicion(false);
//                }
//                break;
//        }
    }
}
