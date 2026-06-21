package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.control.Button;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonGuardar extends Button {

    private Image imagenNormal;
    private Image imagenOscura;
    private ImageView vistaImagen;

    public BotonGuardar(double ancho){
        imagenNormal = new Image(getClass().getResourceAsStream("/botonGuardar.png"));
        imagenOscura = new Image(getClass().getResourceAsStream("/botonGuardarOscuro.png"));

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

        this.setOnMouseEntered(e -> {
            vistaImagen.setImage(imagenOscura);
            this.setCursor(javafx.scene.Cursor.HAND);
        });

        this.setOnMouseExited(e -> {
            vistaImagen.setImage(imagenNormal);
        });


    }


}
