package view;

import javax.swing.*;
import java.awt.*;

public class PanelEditor extends JInternalFrame {
    private JTextArea vistaArchivo;
    private JTextArea consola;
    private JLabel lblNombreArchivo;
    private JButton btnEditar;
    private JButton btnEjecutarLexer;

    public PanelEditor(String titulo, String nombreArchivo) {
        super(titulo, true, true, true, true);
        setSize(900, 600);
        setLayout(new BorderLayout());
        setVisible(true);

        // ---------------- PANEL CENTRAL (VISTA ARCHIVO) ----------------
        vistaArchivo = new JTextArea("VISTA ARCHIVO");
        vistaArchivo.setEditable(false);
        vistaArchivo.setFont(new Font("Consolas", Font.PLAIN, 14));
        vistaArchivo.setBackground(new Color(80, 80, 80));
        vistaArchivo.setForeground(Color.WHITE);

        JScrollPane scrollArchivo = new JScrollPane(vistaArchivo);

        // ---------------- PANEL DERECHA (INFO + BOTONES) ----------------
        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setBackground(Color.BLACK);
        panelDerecha.setPreferredSize(new Dimension(200, 0));

        lblNombreArchivo = new JLabel(nombreArchivo, SwingConstants.CENTER);
        lblNombreArchivo.setForeground(Color.WHITE);
        lblNombreArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNombreArchivo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEditar = new JButton("Editar");
        btnEditar.setBackground(new Color(0, 70, 160));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFocusPainted(false);
        btnEditar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEjecutarLexer = new JButton("Ejecutar Lexer");
        btnEjecutarLexer.setActionCommand("EJECUTAR_LEXER");
        btnEjecutarLexer.setBackground(new Color(0, 70, 160));
        btnEjecutarLexer.setForeground(Color.WHITE);
        btnEjecutarLexer.setFocusPainted(false);
        btnEjecutarLexer.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerecha.add(Box.createVerticalStrut(20));
        panelDerecha.add(lblNombreArchivo);
        panelDerecha.add(Box.createVerticalStrut(30));
        panelDerecha.add(btnEditar);
        panelDerecha.add(Box.createVerticalStrut(15));
        panelDerecha.add(btnEjecutarLexer);

        // ---------------- PANEL INFERIOR (CONSOLA) ----------------
        consola = new JTextArea("CONSOLA");
        consola.setEditable(false);
        consola.setFont(new Font("Consolas", Font.PLAIN, 14));
        consola.setBackground(Color.LIGHT_GRAY);
        consola.setForeground(Color.BLACK);

        JPanel panelConsola = new JPanel(new BorderLayout());
        panelConsola.setPreferredSize(new Dimension(0, 150));

        JLabel lblConsola = new JLabel("CONSOLA", SwingConstants.CENTER);
        lblConsola.setOpaque(true);
        lblConsola.setBackground(new Color(120, 200, 120)); // Verde encabezado
        lblConsola.setForeground(Color.WHITE);
        lblConsola.setFont(new Font("Segoe UI", Font.BOLD, 14));

        panelConsola.add(lblConsola, BorderLayout.NORTH);
        panelConsola.add(new JScrollPane(consola), BorderLayout.CENTER);

        // ---------------- ENSAMBLAR INTERNAL FRAME ----------------
        add(scrollArchivo, BorderLayout.CENTER);
        add(panelDerecha, BorderLayout.EAST);
        add(panelConsola, BorderLayout.SOUTH);
    }

    // Getters para poder interactuar desde fuera
    public JTextArea getVistaArchivo() { return vistaArchivo; }

    public void setVistaArchivo(String vistaArchivo) {
        this.vistaArchivo.setText(vistaArchivo);
    }
    public JTextArea getConsola() { return consola; }

    public void setConsola(String contenidoTokens) {
        this.consola.setText(contenidoTokens);
    }

    public JLabel getLblNombreArchivo() { return lblNombreArchivo; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEjecutarLexer() { return btnEjecutarLexer; }
}
