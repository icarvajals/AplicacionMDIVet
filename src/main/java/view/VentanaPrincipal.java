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
    private JMenuItem Garchivo;

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

        desktopPane = new DesktopConFondo("/imagenes/gestion producto.png");
        setContentPane(desktopPane);

        JMenu abrir = new JMenu("Archivo");
        nuevo = new JMenuItem("Nuevo");
        nuevo.setActionCommand("NUEVO");
        cargar = new JMenuItem("Abrir");
        cargar.setActionCommand("ABRIR");

        abrir.add(nuevo);
        abrir.add(cargar);

        JMenu  guardar = new JMenu("Guardar");
        Garchivo = new JMenuItem("Guardar Archivo");
        Garchivo.setActionCommand("CrearArchivo");
        guardar.add(Garchivo);

        JMenuBar menubar = new JMenuBar();

        menubar.add(abrir);
        menubar.add(guardar);
        setJMenuBar(menubar);

        getDesktopPane().add(panelArchivo);
        getDesktopPane().add(panelEditor);

        getPanelEditor().setVisible(false);
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

    public void setPanelEditor(PanelEditor panelEditor) {
        this.panelEditor = panelEditor;
    }

    public JMenuItem getGarchivo() {
        return Garchivo;
    }

    public void setGarchivo(JMenuItem garchivo) {
        Garchivo = garchivo;
    }
}
