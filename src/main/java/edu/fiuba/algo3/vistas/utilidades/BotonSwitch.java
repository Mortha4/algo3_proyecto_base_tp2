package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class BotonSwitch extends ImageView {
    private final Image imagenNormal;
    private final Image imagenAccion;
    private boolean estaEncendido;

    public BotonSwitch(){
        imagenNormal = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/botonOFF.png")));
        imagenAccion = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/botonON.png")));
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
}
