package edu.fiuba.algo3.vistas.pantallas;


import edu.fiuba.algo3.vistas.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SeleccionJugadoresView extends StackPane {

    public SeleccionJugadoresView() {

        Label titulo = new Label("Cantidad de Jugadores");
        titulo.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");

        Spinner<Integer> spinnerJugadores = new Spinner<>(5, 12, 5);
        spinnerJugadores.setEditable(true);
        spinnerJugadores.setStyle("-fx-font-size: 18px;");

        // Botones
        Button btnVolver = new Button("Volver");
        Button btnConfigurarRoles = new Button("Configurar");
        Button btnContinuar = new Button("Continuar");

        // Estilos
        String styleBtn = "-fx-pref-width: 120px; -fx-pref-height: 40px; -fx-font-size: 14px;";
        btnVolver.setStyle(styleBtn);
        btnConfigurarRoles.setStyle(styleBtn);
        btnContinuar.setStyle(styleBtn);

        // Lógica de navegación
        btnVolver.setOnAction(e -> App.cambiarVentana(new PrincipalView()));

        btnContinuar.setOnAction(e -> {
            int cantidad = spinnerJugadores.getValue();

            App.cambiarVentana(new ConfiguracionPartidaView());
        });

        btnConfigurarRoles.setOnAction(e -> App.cambiarVentana(new ConfiguracionPartidaView()));

        // Layout

        HBox botonesBox = new HBox(15, btnVolver, btnConfigurarRoles,btnContinuar);
        botonesBox.setAlignment(Pos.CENTER);

        VBox contenedor = new VBox(30, titulo, spinnerJugadores, botonesBox);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setMaxSize(400, 300);
        contenedor.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-padding: 20; -fx-background-radius: 10;");

        this.getChildren().add(contenedor);
    }
}