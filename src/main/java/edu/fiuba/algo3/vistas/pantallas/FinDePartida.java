package edu.fiuba.algo3.vistas.pantallas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FinDePartida extends VBox{
    public FinDePartida(String equipoGanador, Runnable alContinuar){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        this.setStyle("-fx-background-color: #000;");
        
        Label titulo = new Label("Ganan los " + equipoGanador);
        titulo.setStyle("-fx-text-fill: white; -fx-font-size: 32px; -fx-font-weight: bold;");

        Label logo = new Label("[Logo]");
        logo.setStyle(
            "-fx-text-fill: #888888; -fx-font-size: 16px;" +
            "-fx-border-color: #555555; -fx-padding: 40 60 40 60;"
        );

        Button continuar = new Button("Continuar");
        continuar.setStyle(
            "-fx-background-color: #6aa84f; -fx-text-fill: white;" +
            "-fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 12 30 12 30;"
        );
        continuar.setOnAction(e -> alContinuar.run());

        this.getChildren().addAll(titulo, logo, continuar);

    }
}
