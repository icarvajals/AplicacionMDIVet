package view;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JDesktopPane desktopPane;
    private PanelArchivo panelArchivo;

    private JMenuItem cargar;

    public VentanaPrincipal(){
        panelArchivo = new PanelArchivo();
        inicializar();
    }

    private void inicializar() {
        setTitle("Apicacon MDI");
        FlatDarculaLaf.setup();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,800);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenu Abrir = new JMenu("Archivo");
        cargar = new JMenuItem("Abrir");
        Abrir.add(cargar);

        JMenu  Guardar = new JMenu("Guardar");
        JMenu  Editar = new JMenu("Editar");
        JMenu Crear = new JMenu("Crear");
        JMenu Lexer = new JMenu("Lexer");



        JMenuBar menubar = new JMenuBar();

        menubar.add(Abrir);
        menubar.add(Guardar);
        menubar.add(Editar);
        menubar.add(Crear);
        menubar.add(Lexer);
        setJMenuBar(menubar);

        getDesktopPane().add(panelArchivo);
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
}
