package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.vistas.Juego;
import edu.fiuba.algo3.vistas.utilidades.BotonGuardar;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.image.Image;

public class ConfiguracionPartidaView extends StackPane {

    private Stage stage;

    public ConfiguracionPartidaView(Stage stage) {
        this.stage = stage;

        //agrego imagenes
        Image imagenFondo = new Image(getClass().getResourceAsStream("/menuConfig.png"));
        ImageView fondoView = new ImageView(imagenFondo);

        //contenedores
        VBox  contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);

        //organizo tamaños
        fondoView.setFitWidth(600);
        fondoView.setFitHeight(720);
        fondoView.setSmooth(false);
        contenido.setPadding(new javafx.geometry.Insets(120, 0, 0, 0));

        //botoneras

        BotonGuardar botonGuardar = new BotonGuardar(320);
        contenido.getChildren().addAll(botonGuardar);
        this.getChildren().addAll(fondoView, contenido);


    }

    private void irAlJuego() {
        // Lógica limpia para cambiar de pantalla usando el stage
        Juego pantallaJuego = new Juego(stage);
        this.stage.getScene().setRoot(pantallaJuego); // Cambia el contenido sin recrear el Stage
        this.stage.setTitle("Juego en Progreso");
    }
}