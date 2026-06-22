package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.vistas.Juego;
import edu.fiuba.algo3.vistas.utilidades.*;
import javafx.geometry.Insets;
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



        //organizo tamaños
        fondoView.setFitWidth(600);
        fondoView.setFitHeight(720);
        fondoView.setSmooth(false);


        VBox rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setPadding(new Insets(100, 40, 40, 40));
        rootLayout.setSpacing(30);

        VBox bloqueOpciones = new VBox();
        bloqueOpciones.setAlignment(Pos.CENTER);
        bloqueOpciones.setSpacing(15);



        ContadorJugadores contador = new ContadorJugadores();
        BotonRolMafioso rolMafia = new BotonRolMafioso();
        BotonRolMedico rolMedico = new BotonRolMedico();
        bloqueOpciones.getChildren().addAll(contador, rolMafia,rolMedico);

        //botones volver y guardar
        VBox bloqueBotones = new VBox();
        bloqueBotones.setAlignment(Pos.CENTER);
        bloqueBotones.setSpacing(12);

        BotonGuardar botonGuardar = new BotonGuardar(320);
        BotonVolver botonVolver = new BotonVolver(200);

        bloqueBotones.getChildren().addAll(botonGuardar, botonVolver);

        rootLayout.getChildren().addAll(bloqueOpciones, bloqueBotones);
        this.getChildren().addAll(fondoView, rootLayout);


    }

    private void irAlJuego() {
        // Lógica limpia para cambiar de pantalla usando el stage
        Juego pantallaJuego = new Juego(stage);
        this.stage.getScene().setRoot(pantallaJuego); // Cambia el contenido sin recrear el Stage
        this.stage.setTitle("Juego en Progreso");
    }
}