package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

public class BotonExit extends Button {

    private Image imagenNormal;
    private ImageView vistaImagen;

    public BotonExit(double ancho){
        imagenNormal = new Image(getClass().getResourceAsStream("/botonExit.png"));

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

        String rutaClick = getClass().getResource("/sounds/click1.wav").toExternalForm();
        AudioClip clipClick = new AudioClip(rutaClick);

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

        this.setOnMouseClicked(e -> {
            clipClick.play();
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




}
