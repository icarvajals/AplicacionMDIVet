package view;

import javax.swing.*;
import java.awt.*;

public class PanelArchivo extends JInternalFrame {

    private JLabel lblTitulo;
    private JLabel lblSubtitulo;
    private JButton btnArchivo;
    private JLabel lblFormato;
    private JLabel lblIcono;

    public PanelArchivo(){
        super("Abrir Archivo", true, true, true, true);
        setSize(400, 300);
        setLayout(new GridLayout());

        setLayout(new BorderLayout());

        // -------- Panel superior (Título y subtítulo) --------
        JPanel panelSuperior = new JPanel(new GridLayout(2, 1));
        panelSuperior.setBackground(new Color(30, 50, 70)); // azul oscuro
        panelSuperior.setPreferredSize(new Dimension(500, 100));

        lblTitulo = new JLabel("ANALIZADOR LÉXICO", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);

        lblSubtitulo = new JLabel("Carga un archivo .txt y obtén los tokens de tu código", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSubtitulo.setForeground(Color.LIGHT_GRAY);

        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblSubtitulo);

        // -------- Panel central (ícono + botón) --------
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(Color.WHITE);

        // Ícono
        lblIcono = new JLabel(new ImageIcon("src/imagenes/logoArchivo.png")); // cambia la ruta
        lblIcono.setHorizontalAlignment(SwingConstants.CENTER);

        // Botón personalizado
        btnArchivo = new JButton("Seleccionar archivo");
        btnArchivo.setBackground(new Color(255, 140, 0)); // naranja
        btnArchivo.setForeground(Color.WHITE);
        btnArchivo.setFont(new Font("Arial", Font.BOLD, 16));
        btnArchivo.setFocusPainted(false);
        btnArchivo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.WHITE);
        panelBoton.add(btnArchivo);

        panelCentral.add(lblIcono, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);

        // -------- Panel inferior (texto formatos) --------
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.WHITE);
        lblFormato = new JLabel("Formatos permitidos: .txt");
        lblFormato.setFont(new Font("Arial", Font.ITALIC, 12));
        lblFormato.setForeground(Color.DARK_GRAY);
        panelInferior.add(lblFormato);

        // -------- Agregar todo --------
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }
}
