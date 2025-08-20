package view;

import javax.swing.*;
import java.awt.*;

public class PanelResultados extends JInternalFrame {

    private JTextArea txtContenido;
    private JTextArea txtTokens;

    public PanelResultados() {
        super("Resultados", true, true, true, true);
        inicializar();
    }

    private void inicializar() {
        setSize(900, 500);
        setLayout(new BorderLayout());


        JPanel panelSuperior = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint grad = new GradientPaint(0, 0, new Color(33, 54, 75),
                        getWidth(), getHeight(), new Color(55, 71, 90));
                g2.setPaint(grad);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelSuperior.setPreferredSize(new Dimension(800, 140));
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));

        JLabel lblTitulo = new JLabel("ANALIZADOR LÉXICO");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(Box.createVerticalStrut(35));
        panelSuperior.add(lblTitulo);

        add(panelSuperior, BorderLayout.NORTH);


        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 20, 0));
        panelCentral.setBackground(new Color(240, 242, 245));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JPanel panelIzq = crearPanel("Contenido del Archivo", new Color(100, 140, 237), Color.WHITE);
        txtContenido = new JTextArea();
        txtContenido.setBackground(new Color(250, 250, 250));
        txtContenido.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);
        JScrollPane scrollIzq = new JScrollPane(txtContenido);
        scrollIzq.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelIzq.add(scrollIzq, BorderLayout.CENTER);


        JPanel panelDer = crearPanel("Tokens Encontrados", new Color(100, 140, 237), Color.white);
        txtTokens = new JTextArea();
        txtTokens.setBackground(new Color(250, 250, 250));
        txtTokens.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtTokens.setLineWrap(true);
        txtTokens.setWrapStyleWord(true);
        JScrollPane scrollDer = new JScrollPane(txtTokens);
        scrollDer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDer.add(scrollDer, BorderLayout.CENTER);

        panelCentral.add(panelIzq);
        panelCentral.add(panelDer);

        add(panelCentral, BorderLayout.CENTER);

        setVisible(true);
    }


    private JPanel crearPanel(String titulo, Color bgColor, Color fgColor) {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // sombra
                g2.setColor(new Color(0, 0, 0, 30));
                g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);

                // fondo
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 20, 20);
            }
        };
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        JPanel header = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(bgColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // redondeado
            }
        };
        header.setOpaque(false);
        header.setPreferredSize(new Dimension(0, 40));
        header.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setForeground(fgColor);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.add(lblTitulo, BorderLayout.CENTER);

        panel.add(header, BorderLayout.NORTH);

        return panel;
    }

    public JTextArea getTxtContenido() {
        return txtContenido;
    }

    public JTextArea getTxtTokens() {
        return txtTokens;
    }
}
