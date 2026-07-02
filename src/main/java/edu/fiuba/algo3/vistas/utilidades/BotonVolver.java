package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class BotonVolver extends Button {

    private final ImageView vistaImagen;

    public BotonVolver(double ancho){
        Image imagenNormal = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/botonVolver.png")));

        vistaImagen = new ImageView(imagenNormal);

        vistaImagen.setFitWidth(ancho);
        vistaImagen.setPreserveRatio(true);
        vistaImagen.setSmooth(false);

        this.setGraphic(vistaImagen);
        this.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        this.setPrefSize(220, 70);

        initEventosEfecto();


    }

    private void initEventosEfecto() {

        ColorAdjust oscuro = new ColorAdjust();
        oscuro.setBrightness(-0.4); // Entre -0.2 y -0.5 suele quedar bien

        this.setOnMouseEntered(e -> {
            vistaImagen.setEffect(oscuro);
            this.setCursor(javafx.scene.Cursor.HAND);
        });

        this.setOnMouseExited(e -> {
            vistaImagen.setEffect(null);
        });


    }

    public void setOnActionGuardar(Runnable accion) {
        this.setOnAction(e -> {
            if (accion != null) {
                accion.run();
            }
        });
    }


}
