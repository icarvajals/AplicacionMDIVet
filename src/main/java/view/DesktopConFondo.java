package view;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

class DesktopConFondo extends JDesktopPane {

    private final Image image;

    public DesktopConFondo(String resourcePath) {
        // Carga desde el classpath, p.ej. src/main/resources/imagenes/logo.png
        URL url = getClass().getResource(resourcePath);
        image = (url != null) ? new ImageIcon(url).getImage() : null;
        setBackground(new Color(33,37,43)); // color base
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int w = image.getWidth(this), h = image.getHeight(this);
            int x = (getWidth()  - w) / 2;
            int y = (getHeight() - h) / 2;
            g.drawImage(image, x, y, this);
 }
}
}