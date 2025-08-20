package view;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JDesktopPane desktopPane;
    private PanelArchivo panelArchivo;
    private PanelResultados panelResultados;
    private PanelVistaArchivo panelVistaArchivo;
    private JMenuItem cargar;
    private JMenuItem nuevo;
    private JMenuItem analizador;
    private JMenuItem editarDocumento;



    public VentanaPrincipal(){
        panelArchivo = new PanelArchivo();
        panelResultados = new PanelResultados();
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
        JMenu  editar = new JMenu("Editar");
        editarDocumento = new JMenuItem("Editar Documento");
        editarDocumento.setActionCommand("EDITAR");
        editar.add(editarDocumento);
        JMenu crear = new JMenu("Crear");


        JMenu lexer = new JMenu("Lexer");
        analizador = new JMenuItem("Analizador léxico");
        analizador.setActionCommand("ANALIZADOR_LÉXICO");
        lexer.add(analizador);



        JMenuBar menubar = new JMenuBar();

        menubar.add(abrir);
        menubar.add(guardar);
        menubar.add(editar);
        menubar.add(crear);
        menubar.add(lexer);
        setJMenuBar(menubar);

        getDesktopPane().add(panelArchivo);
        getDesktopPane().add(panelResultados);

        panelResultados.setVisible(false);
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

    public PanelResultados getPanelResultados() {
        return panelResultados;
    }

    public void setPanelResultados(PanelResultados panelResultados) {
        this.panelResultados = panelResultados;
    }
    public PanelVistaArchivo getPanelVistaArchivo() {
        return panelVistaArchivo;
    }

    public void setPanelVistaArchivo(PanelVistaArchivo panelVistaArchivo) {
        this.panelVistaArchivo = panelVistaArchivo;
    }

    public void setCargar(JMenuItem cargar) {
        this.cargar = cargar;
    }

    public JMenuItem getAnalizador() {
        return analizador;
    }

    public void setAnalizador(JMenuItem analizador) {
        this.analizador = analizador;
    }

    public JMenuItem getNuevo() {
        return nuevo;
    }

    public void setNuevo(JMenuItem nuevo) {
        this.nuevo = nuevo;
    }

    public JMenuItem getEditarDocumento() {
        return editarDocumento;
    }

    public void setEditarDocumento(JMenuItem editarDocumento) {
        this.editarDocumento = editarDocumento;
    }
}
