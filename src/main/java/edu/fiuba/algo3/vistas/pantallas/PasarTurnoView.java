package edu.fiuba.algo3.vistas.pantallas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PasarTurnoView extends VBox{
    
    public PasarTurnoView(String nombre, Runnable alContinuar) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);
        this.setStyle("-fx-background-color: #1a1a1a;");

        Label texto = new Label("Turno de "+ nombre);
        texto.setStyle("-fx-text-fill: #fff; -fx-font-size: 28px; -fx-font-weight: bold;");
    
        Button continuar = new Button("Continuar");
        continuar.setStyle(
            "-fx-background-color: #6aa84f;" +
            "-fx-text-fill: #fff;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 12 30 12 30;"
        );
        continuar.setOnAction(e -> alContinuar.run());
        this.getChildren().addAll(texto, continuar);
    }

}
