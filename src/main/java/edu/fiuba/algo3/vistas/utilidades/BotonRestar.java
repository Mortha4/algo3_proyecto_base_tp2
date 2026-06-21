package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonRestar extends ImageView {

    private Image imagenNormal;
    private Runnable accionClick;



    public BotonRestar(){
        imagenNormal = new Image(getClass().getResourceAsStream("/botonRestar.png"));

        this.setImage(imagenNormal);

        this.setFitWidth(60);
        this.setPreserveRatio(true);
        this.setSmooth(false);


        this.setOnMouseEntered(e -> this.setCursor(Cursor.HAND));

        this.setOnMouseClicked(e -> {
            if (accionClick != null) {
                accionClick.run();
            }

        });

    }

    public void accionRestar(Runnable accion) {
        this.accionClick = accion;
    }


}
