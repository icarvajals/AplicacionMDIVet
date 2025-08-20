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
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

        // ---------------- PANEL CENTRAL (VISTA ARCHIVO) ----------------
        vistaArchivo = new JTextArea("VISTA ARCHIVO");
        vistaArchivo.setEditable(false);
        vistaArchivo.setFont(new Font("Consolas", Font.PLAIN, 14));
        vistaArchivo.setBackground(Color.WHITE);
        vistaArchivo.setForeground(new Color(44, 62, 80));  // azul oscuro-gris

        JScrollPane scrollArchivo = new JScrollPane(vistaArchivo);
        scrollArchivo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                "Código Fuente",
                0, 0, new Font("Segoe UI", Font.BOLD, 13),
                new Color(44, 62, 80)
        ));

        // ---------------- PANEL DERECHA (INFO + BOTONES) ----------------
        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setBackground(new Color(236, 240, 241)); // gris claro
        panelDerecha.setPreferredSize(new Dimension(200, 0));
        panelDerecha.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(200, 200, 200)));

        lblNombreArchivo = new JLabel(nombreArchivo, SwingConstants.CENTER);
        lblNombreArchivo.setForeground(new Color(44, 62, 80));
        lblNombreArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNombreArchivo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEditar = createStyledButton("Editar");
        btnEditar.setActionCommand("EDITAR");
        btnEditar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEjecutarLexer = createStyledButton("Ejecutar Lexer");
        btnEjecutarLexer.setActionCommand("EJECUTAR_LEXER");
        btnEjecutarLexer.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerecha.add(Box.createVerticalStrut(20));
        panelDerecha.add(lblNombreArchivo);
        panelDerecha.add(Box.createVerticalStrut(30));
        panelDerecha.add(btnEditar);
        panelDerecha.add(Box.createVerticalStrut(15));
        panelDerecha.add(btnEjecutarLexer);

        // ---------------- PANEL INFERIOR (CONSOLA) ----------------
        consola = new JTextArea();
        consola.setEditable(false);
        consola.setFont(new Font("Consolas", Font.PLAIN, 14));
        consola.setBackground(new Color(44, 62, 80));   // azul oscuro
        consola.setForeground(new Color(46, 204, 113)); // verde terminal
        consola.setCaretColor(Color.WHITE);

        JPanel panelConsola = new JPanel(new BorderLayout());
        panelConsola.setPreferredSize(new Dimension(0, 150));
        panelConsola.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200)));

        JLabel lblConsola = new JLabel("CONSOLA", SwingConstants.CENTER);
        lblConsola.setOpaque(true);
        lblConsola.setBackground(new Color(44, 62, 80)); // azul encabezado
        lblConsola.setForeground(Color.WHITE);
        lblConsola.setFont(new Font("Segoe UI", Font.BOLD, 14));

        panelConsola.add(lblConsola, BorderLayout.NORTH);
        panelConsola.add(new JScrollPane(consola), BorderLayout.CENTER);

        // ---------------- ENSAMBLAR INTERNAL FRAME ----------------
        add(scrollArchivo, BorderLayout.CENTER);
        add(panelDerecha, BorderLayout.EAST);
        add(panelConsola, BorderLayout.SOUTH);
    }

    // Método helper para botones estilo moderno (naranja)
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(230, 126, 34)); // naranja
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // hover
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(211, 84, 0)); // naranja más oscuro
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(230, 126, 34));
            }
        });
        return btn;
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
