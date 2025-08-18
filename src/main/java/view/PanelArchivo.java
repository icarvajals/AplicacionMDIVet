package view;

import javax.swing.*;
import java.awt.*;

public class PanelArchivo extends JInternalFrame {

    private JButton btnArchivo;
    private JLabel fondo;

    public PanelArchivo() {
        super("Archivo", true, true, true, true);
        setSize(800, 600);

        fondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/FondoLexer2.png")));
        fondo.setLayout(new GridBagLayout());
        add(fondo);

        btnArchivo = new JButton("Seleccionar archivo");
        btnArchivo.putClientProperty("JButton.arc", 40);

        btnArchivo.setBackground(new Color(255, 140, 0));
        btnArchivo.setForeground(Color.WHITE);
        btnArchivo.setFont(new Font("Arial", Font.BOLD, 16));
        btnArchivo.setFocusPainted(false);
        btnArchivo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        btnArchivo.setContentAreaFilled(false);
        btnArchivo.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1;
        gbc.insets = new Insets(200, 0, 0, 90);

        fondo.add(btnArchivo, gbc);

        setVisible(true);
    }

    public JButton getBtnArchivo() {
        return btnArchivo;
    }
}
