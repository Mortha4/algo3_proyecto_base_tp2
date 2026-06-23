package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonSwitch extends ImageView {

    private Image imagenNormal;
    private Image imagenAccion;
    private boolean estaEncendido;

    private ImageView vistaImagen;

    public BotonSwitch(){
        imagenNormal = new Image(getClass().getResourceAsStream("/botonOFF.png"));
        imagenAccion = new Image(getClass().getResourceAsStream("/botonON.png"));
        estaEncendido = false;

        this.setImage(imagenNormal);

        this.setFitWidth(110);
        this.setPreserveRatio(true);
        this.setSmooth(false);
        this.setCursor(Cursor.HAND);

        this.setOnMouseClicked(e -> alternarEstado());

    }

    private void alternarEstado(){
        estaEncendido = !estaEncendido;

        if (estaEncendido) {
            this.setImage(imagenAccion);
        } else {
            this.setImage(imagenNormal);
        }
    }

    public boolean estaActivado() {
        return estaEncendido;
    }

}
