package view;

import javax.swing.*;
import java.awt.*;

public class PanelArchivo extends JInternalFrame {

    private JButton btnArchivo;

    public PanelArchivo() {
        super("Archivo", true, true, true, true);
        inicializar();
    }

    private void inicializar() {
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Panel superior (encabezado azul oscuro)
        JPanel panelSuperior = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(33, 54, 75)); // Azul oscuro
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelSuperior.setPreferredSize(new Dimension(800, 120));
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));

        JLabel lblTitulo = new JLabel("COMPILADOr VETERINARIA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("Carga un archivo .txt y obtén los tokens de tu código");
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSubtitulo.setForeground(Color.WHITE);
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(Box.createVerticalStrut(20));
        panelSuperior.add(lblTitulo);
        panelSuperior.add(Box.createVerticalStrut(10));
        panelSuperior.add(lblSubtitulo);


        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridBagLayout());
        panelCentral.setBackground(new Color(245, 247, 249)); // Gris claro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);


        JLabel lblIcono = new JLabel("\uD83D\uDCC4\uD83D\uDD0D");
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));
        panelCentral.add(lblIcono, gbc);


        btnArchivo = new JButton("Seleccionar archivo");
        btnArchivo.setActionCommand("SELECCIONAR_ARCHIVO");
        btnArchivo.setBackground(new Color(255, 140, 0));
        btnArchivo.setForeground(Color.WHITE);
        btnArchivo.setFont(new Font("Arial", Font.BOLD, 16));
        btnArchivo.setFocusPainted(false);
        btnArchivo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnArchivo.setOpaque(true);

        gbc.gridy = 1;
        panelCentral.add(btnArchivo, gbc);

        JLabel lblFormatos = new JLabel("Formatos permitidos: .txt");
        lblFormatos.setFont(new Font("Arial", Font.PLAIN, 14));
        lblFormatos.setForeground(Color.DARK_GRAY);
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        panelCentral.add(lblFormatos, gbc);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    public JButton getBtnArchivo() {
        return btnArchivo;
    }
}
