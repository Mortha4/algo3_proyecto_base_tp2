package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.vistas.App;
import edu.fiuba.algo3.vistas.utilidades.BotonExit;
import edu.fiuba.algo3.vistas.utilidades.BotonJugar;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;

public class PrincipalView extends StackPane {

    public PrincipalView() {

        ImageView background = new ImageView(new Image("/wallpaper.png"));
        background.setFitWidth(1920);
        background.setFitHeight(720);
        background.setPreserveRatio(false);


        VBox menuBox = new VBox(-50);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setMaxSize(300, 200);



        BotonJugar botonJugar = new BotonJugar(350);

        botonJugar.setOnActionConSonido(()-> {
            App.cambiarVentana(new SeleccionJugadoresView());
        });

        BotonExit botonSalir = new BotonExit(350);


        botonSalir.setOnAction(e -> Platform.exit());


        menuBox.getChildren().addAll(botonJugar, botonSalir);

        this.getChildren().addAll(background, menuBox);
    }
}