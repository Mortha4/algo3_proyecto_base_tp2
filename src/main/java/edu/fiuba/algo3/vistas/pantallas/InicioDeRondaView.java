package edu.fiuba.algo3.vistas.pantallas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InicioDeRondaView extends VBox{
    public InicioDeRondaView(int numeroDeRonda, String muerto, Runnable alContinuar){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        this.setStyle("-fx-background-color: #000");

        Label titulo = new Label("Ronda " + numeroDeRonda);
        titulo.setStyle("-fx-text-fill: #fff; -fx-font-size: 30px; -fx-font-weight: bold;");
        String mensaje = null;
        if(numeroDeRonda > 0){
            mensaje = (muerto == null) ? "Nadie murió esta noche" : "Murio " + muerto;
        }
        Label labelMuerte = new Label(mensaje);
        labelMuerte.setStyle("-fx-text-fill: #ddd; -fx-font-size: 18px;");
        
        Button continuar = new Button("Continuar");
        continuar.setStyle(
            "-fx-background-color: #6aa84f;" +
            "-fx-text-fill: #fff;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 12 30 12 30;"
        );
        continuar.setOnAction(e -> alContinuar.run());

        this.getChildren().addAll(titulo,labelMuerte,continuar);
    }
}
