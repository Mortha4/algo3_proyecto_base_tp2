package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class TarjetaDeJugador extends HBox{
    public TarjetaDeJugador(String nombre, String Rol) {
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5; ");

        Region jugador = new Region();
        jugador.setMinSize(60,60);
        jugador.setMaxSize(60,60);
        jugador.setStyle("-fx-background-color: #d5f0d5; -fx-border-color: #aaaaaa;");

        Label labelNombre = new Label(nombre);
        labelNombre.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Label labelRol = new Label(Rol);
        labelRol.setStyle("-fx-border-color: #cccccc; -fx-padding: 2 8 2 8; -fx-font-size: 11px;");

        HBox mazo = new HBox(3);
        for (int i = 0; i < 8; i++) {
            Region tarjeta = new Region();
            tarjeta.setMinSize(18,22);
            tarjeta.setMaxSize(18,22);
            tarjeta.setStyle("-fx-border-color: #999999;");
            mazo.getChildren().add(tarjeta);
        }

        VBox datos = new VBox(6, labelNombre, labelRol, mazo);
        datos.setAlignment(Pos.CENTER_LEFT);

        this.getChildren().addAll(jugador,datos);

    }
}
