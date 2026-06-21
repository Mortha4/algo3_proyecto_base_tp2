package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class TarjetaDeJugador extends HBox{
    public TarjetaDeJugador(String nombre, String Rol, int cantVotos) {
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5; ");

        Label labelNombre = new Label(nombre);
        labelNombre.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Label labelRol = new Label(Rol);
        labelRol.setStyle("-fx-border-color: #cccccc; -fx-padding: 2 8 2 8; -fx-font-size: 11px;");

        HBox casillas = new HBox(3);
        for (int i = 0; i < (cantVotos-1); i++) {
            Region casilla = new Region();
            casilla.setMinSize(10,22);
            casilla.setMaxSize(10,22);
            casilla.setStyle("-fx-border-color: #999999;");
            casillas.getChildren().add(casilla);
        }

        VBox datos = new VBox(6, labelNombre, labelRol, casillas);
        datos.setAlignment(Pos.CENTER_LEFT);

        this.getChildren().addAll(crearAvatar(),datos);

    }

    private static StackPane crearAvatar(){
        Region cabeza = new Region();
        cabeza.setMinSize(22,22);
        cabeza.setMaxSize(22,22);
        cabeza.setStyle("-fx-background-color: #d5e8d4; -fx-border-color: #82b366;");

        Region cuerpo = new Region();
        cuerpo.setMinSize(36, 18);
        cuerpo.setMaxSize(36, 18);
        cuerpo.setStyle("-fx-background-color: #d5e8d4; -fx-border-color: #82b366;");

        VBox personaje = new VBox(2, cabeza, cuerpo);
        personaje.setAlignment(Pos.CENTER);

        StackPane avatar = new StackPane(personaje);
        avatar.setMinSize(60, 60);
        avatar.setMaxSize(60, 60);
        avatar.setStyle("-fx-background-color: white; -fx-border-color: #aaaaaa;");

        return avatar;
    }
}
