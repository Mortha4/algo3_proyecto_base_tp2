package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.vistas.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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


        VBox menuBox = new VBox(20);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setMaxSize(300, 200);


        String btnStyle = "-fx-font-size: 20px; -fx-pref-width: 200px; -fx-pref-height: 50px; " +
                "-fx-background-color: #2c3e50; -fx-text-fill: white; -fx-cursor: hand;";

        Button btnJugar = new Button("Jugar");
        btnJugar.setStyle(btnStyle);

        btnJugar.setOnAction(e -> {
            App.cambiarVentana(new SeleccionJugadoresView());
        });



        Button btnSalir = new Button("Salir");

        btnSalir.setStyle(btnStyle);

        btnSalir.setOnAction(e -> Platform.exit());


        menuBox.getChildren().addAll(btnJugar, btnSalir);

        this.getChildren().addAll(background, menuBox);
    }
}