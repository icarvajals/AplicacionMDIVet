package controller;

import view.VentanaPrincipal;

public class Controller {

    private VentanaPrincipal ventp;

    public Controller(){
        ventp = new VentanaPrincipal();
        funcionar();
    }

    private void funcionar() {
        ventp.setVisible(true);

        ventp.getCargar().addActionListener(e -> {
            ventp.getPanelArchivo().setVisible(true);
        });

    }
}
