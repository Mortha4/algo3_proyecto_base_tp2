package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

import java.util.Objects;

public class BotonJugar extends Button {

    private final ImageView vistaImagen;

    public BotonJugar(double ancho){
        Image imagenNormal = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/botonJugar.png")));

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

        String rutaSonido = getClass().getResource("/sounds/switch7.wav").toExternalForm();
        AudioClip clip = new AudioClip(rutaSonido);


        DropShadow sombra = new DropShadow();
        sombra.setColor(Color.web("#d4af37"));
        sombra.setRadius(20);
        sombra.setSpread(0.5);

        this.setOnMouseEntered(e -> {
            vistaImagen.setEffect(sombra);
            vistaImagen.setScaleX(1.05);
            vistaImagen.setScaleY(1.05);
            clip.play();
            this.setCursor(Cursor.HAND);
        });


        this.setOnMouseExited(e -> {
            vistaImagen.setEffect(null);
            vistaImagen.setScaleX(1);
            vistaImagen.setScaleY(1);
        });

        this.setOnMouseExited(e -> {
            vistaImagen.setEffect(null);
        });
    }

    public void setOnActionConSonido(Runnable accion) {
        this.setOnMouseClicked(e -> {
            String rutaClick = getClass().getResource("/sounds/click1.wav").toExternalForm();
            AudioClip clipClick = new AudioClip(rutaClick);
            clipClick.play();


            javafx.animation.PauseTransition delay = new javafx.animation.PauseTransition(javafx.util.Duration.millis(100));
            delay.setOnFinished(event -> accion.run());
            delay.play();
        });
    }



}
