package controller;

import model.Archivo;

public class AplMain {
    public static void main(String[] args) {
        Archivo ar = new Archivo();
        Controller c = new Controller();

        c.leerArchivo(ar);
    }
}
