package view;

import javax.swing.*;
import java.awt.*;

public class PanelVistaArchivo extends JInternalFrame {

    private JTextArea txtContenido;

    public PanelVistaArchivo(String nombreArchivo, String contenido) {
        super("Contenido: " + nombreArchivo, true, true, true, true);
        inicializar(contenido);
    }

    private void inicializar(String contenido) {
        setSize(600, 400);
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 249)); // Fondo claro general

        // Panel superior con degradado más vibrante y borde sutil
        JPanel panelSuperior = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(33, 54, 75)); // azul oscuro sólido
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Borde inferior sutil para resaltar
                g2.setColor(new Color(255, 255, 255, 100));
                g2.fillRect(0, getHeight() - 5, getWidth(), 5);
            }
        };
        panelSuperior.setPreferredSize(new Dimension(800, 80));
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Icono lápiz (emoji)
        JLabel iconoLapiz = new JLabel("\u270E"); // ✎ emoji lápiz
        iconoLapiz.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 26));
        iconoLapiz.setForeground(Color.WHITE);

        JLabel lblTitulo = new JLabel("Vista previa del archivo");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);

        panelSuperior.add(iconoLapiz);
        panelSuperior.add(lblTitulo);

        // Panel central con GridBagLayout para centrar JTextArea y controlar tamaño
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(new Color(245, 247, 249)); // Gris muy claro

        txtContenido = new JTextArea(contenido);
        txtContenido.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtContenido.setEditable(false);
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);
        txtContenido.setBackground(new Color(255, 255, 240));
        txtContenido.setForeground(Color.BLACK);
        txtContenido.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(33, 54, 75), 2, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10))
        );

        JScrollPane scroll = new JScrollPane(txtContenido);
        scroll.setBorder(BorderFactory.createEmptyBorder()); // quitar bordes extra

        // Tamaño preferido (puedes ajustar según gusto)
        scroll.setPreferredSize(new Dimension(550, 350));
        scroll.setMaximumSize(new Dimension(600, 400));
        scroll.setMinimumSize(new Dimension(300, 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Para que el scroll no se estire para llenar todo, quitamos fill
        gbc.fill = GridBagConstraints.NONE;

        // Centrar horizontal y vertical
        gbc.anchor = GridBagConstraints.CENTER;

        // Márgenes alrededor
        gbc.insets = new Insets(20, 20, 20, 20);

        panelCentral.add(scroll, gbc);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);

        setVisible(true);
    }

    public JTextArea getTxtContenido() {
        return txtContenido;
    }
}
