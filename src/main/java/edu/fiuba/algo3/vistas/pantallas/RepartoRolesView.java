package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.vistas.App;
import edu.fiuba.algo3.controllers.PartidaController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RepartoRolesView extends StackPane {
    private int jugadorActual;
    private int totalJugadores;
    private PartidaController controlador;

    public RepartoRolesView(int jugadorActual, int totalJugadores, PartidaController controlador) {

        this.jugadorActual = jugadorActual;
        this.totalJugadores = totalJugadores;
        this.controlador = controlador;

        Label lblJugador = new Label("Jugador " + jugadorActual + ", presiona para ver tu rol");
        Button btnRevelar = new Button("Revelar");
        Label lblRol = new Label();
        lblRol.setVisible(false);

        btnRevelar.setOnAction(e -> {
            // Aquí obtienes el rol del controlador
            String rol = controlador.obtenerRolDeJugador(jugadorActual);
            lblRol.setText("Tu rol es: " + rol);
            lblRol.setVisible(true);
            btnRevelar.setVisible(false);
        });

        Button btnSiguiente = new Button("Ocultar y Pasar");

        btnSiguiente.setOnAction(e -> {
            if (jugadorActual < totalJugadores) {
                App.cambiarVentana(new RepartoRolesView(jugadorActual + 1, totalJugadores, controlador));
            } else {

                App.cambiarVentana(new InicioDeRondaView(1,"test",null));
            }
        });

        VBox layout = new VBox(20, lblJugador, btnRevelar, lblRol, btnSiguiente);
        layout.setAlignment(Pos.CENTER);
        this.getChildren().add(layout);
    }
}