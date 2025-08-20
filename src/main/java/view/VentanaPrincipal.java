package view;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JDesktopPane desktopPane;
    private PanelArchivo panelArchivo;
    private PanelEditor panelEditor;
    private PanelVistaArchivo panelVistaArchivo;
    private JMenuItem cargar;
    private JMenuItem nuevo;

    public VentanaPrincipal(){
        panelArchivo = new PanelArchivo();
        panelEditor = new PanelEditor("Editor", "Archivo1");
        inicializar();
    }

    private void inicializar() {
        setTitle("Aplicación MDI");
        FlatDarculaLaf.setup();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,800);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenu abrir = new JMenu("Archivo");
        nuevo = new JMenuItem("Nuevo");
        nuevo.setActionCommand("NUEVO");
        cargar = new JMenuItem("Abrir");
        cargar.setActionCommand("ABRIR");

        abrir.add(nuevo);
        abrir.add(cargar);

        JMenu  guardar = new JMenu("Guardar");
        JMenuBar menubar = new JMenuBar();

        menubar.add(abrir);
        menubar.add(guardar);
        setJMenuBar(menubar);

        getDesktopPane().add(panelArchivo);
        getDesktopPane().add(panelEditor);

        getPanelEditor().setVisible(false);

    }
    public void mostrarContenidoArchivo(String nombreArchivo, String contenido) {
        panelVistaArchivo = new PanelVistaArchivo(nombreArchivo, contenido);
        desktopPane.add(panelVistaArchivo);
        panelVistaArchivo.setLocation(30, 30);
        panelVistaArchivo.setVisible(true);
    }

    public void agregarDocumento(JInternalFrame panelNuevo){
        desktopPane.add(panelNuevo);
        panelNuevo.setLocation(30, 30);
        panelNuevo.setVisible(true);
        try {
            panelNuevo.setSelected(true);
            panelNuevo.toFront();
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public PanelArchivo getPanelArchivo() {
        return panelArchivo;
    }

    public void setPanelArchivo(PanelArchivo panelArchivo) {
        this.panelArchivo = panelArchivo;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public JMenuItem getCargar() {
        return cargar;
    }

    public PanelVistaArchivo getPanelVistaArchivo() {
        return panelVistaArchivo;
    }

    public void setPanelVistaArchivo(PanelVistaArchivo panelVistaArchivo) {
        this.panelVistaArchivo = panelVistaArchivo;
    }

    public PanelEditor getPanelEditor() {
        return panelEditor;
    }

    public void setCargar(JMenuItem cargar) {
        this.cargar = cargar;
    }

    public JMenuItem getNuevo() {
        return nuevo;
    }

    public void setNuevo(JMenuItem nuevo) {
        this.nuevo = nuevo;
    }

}
