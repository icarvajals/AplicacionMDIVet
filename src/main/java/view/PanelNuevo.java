package view;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class PanelNuevo extends JInternalFrame {

        private JTextArea textArea;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnEditar;
    private JPanel panelBotones;

    public PanelNuevo(String titulo, String contenidoInicial, boolean esEditable) {
        super(titulo, true, true, true, true);
        initComponents(contenidoInicial, esEditable);
    }

        private void initComponents(String contenidoInicial, boolean esEditable) {
            setSize(600, 400);
            setLayout(new BorderLayout());

            textArea = new JTextArea();
            textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
            textArea.setForeground(Color.WHITE);
            textArea.setBackground(new Color(43, 43, 43));
            textArea.setCaretColor(Color.WHITE);
            textArea.setText(contenidoInicial);
            textArea.setEditable(esEditable);

            // Scroll pane with modern border
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
            add(scrollPane, BorderLayout.CENTER);


            // Panel inferior para botones guardar, cancelar, por ejemplo (opcional)
            panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelBotones.setBackground(new Color(60, 63, 65));

            btnGuardar = new JButton("Guardar");
            btnCancelar = new JButton("Cancelar");
            btnEditar = new JButton(new ImageIcon("lapiz.png"));

            btnGuardar.setFocusPainted(false);
            btnCancelar.setFocusPainted(false);
            btnEditar.setFocusPainted(false);
            btnEditar.setVisible(!esEditable);
            btnGuardar.setVisible(esEditable);
            btnCancelar.setVisible(esEditable);

            btnGuardar.setActionCommand("GUARDAR");
            btnCancelar.setActionCommand("CANCELAR");
            btnEditar.setActionCommand("EDITAR2");

            panelBotones.add(btnGuardar);
            panelBotones.add(btnCancelar);
            panelBotones.add(btnEditar);

            add(panelBotones, BorderLayout.SOUTH);

            putClientProperty("JInternalFrame.frameType", "normal");
        }
    public void mostrarModoEdicion(boolean editable) {
        textArea.setEditable(editable);
        btnGuardar.setVisible(editable);
        btnCancelar.setVisible(editable);
        btnEditar.setVisible(!editable);
        if (editable) {
            textArea.requestFocus();
        }
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }
}


