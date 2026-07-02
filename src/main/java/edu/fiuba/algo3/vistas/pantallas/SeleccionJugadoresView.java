package edu.fiuba.algo3.vistas.pantallas;


import edu.fiuba.algo3.controllers.PartidaController;
import edu.fiuba.algo3.vistas.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SeleccionJugadoresView extends StackPane {

    private PartidaController controlador;

    public SeleccionJugadoresView() {

        Label titulo = new Label("Cantidad de Jugadores");
        titulo.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");

        Spinner<Integer> spinnerJugadores = new Spinner<>(5, 12, 5);
        spinnerJugadores.setEditable(false);
        spinnerJugadores.setStyle("-fx-font-size: 18px;");

        // Botones
        Button botonVolver = new Button("Volver");
        Button botonConfigurarRoles = new Button("Configurar");
        Button botonContinuar = new Button("Continuar");

        // Estilos
        String styleBoton = "-fx-pref-width: 120px; -fx-pref-height: 40px; -fx-font-size: 14px;";
        botonVolver.setStyle(styleBoton);
        botonConfigurarRoles.setStyle(styleBoton);
        botonContinuar.setStyle(styleBoton);

        // Lógica de navegación
        botonVolver.setOnAction(e -> App.cambiarVentana(new PrincipalView()));

        botonContinuar.setOnAction(e -> {
            Runnable accionContinue = () -> App.cambiarVentana(new InicioDeRondaView(1,null,() -> {

                System.out.println("Iniciando ronda...");
                App.cambiarVentana(new InicioDeRondaView(2,null,() -> {

                    System.out.println("ultimo");
                    App.cambiarVentana(new FinDePartida("inserte ganador",() -> App.cambiarVentana(new PrincipalView())));
                }));
            }));


            App.cambiarVentana(new RevelarRol("inserte su rol",accionContinue));
        });

        botonConfigurarRoles.setOnAction(e -> App.cambiarVentana(new ConfiguracionPartidaView()));

        // Layout

        HBox botonesBox = new HBox(15, botonVolver, botonConfigurarRoles,botonContinuar);
        botonesBox.setAlignment(Pos.CENTER);

        VBox contenedor = new VBox(30, titulo, spinnerJugadores, botonesBox);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setMaxSize(400, 300);
        contenedor.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-padding: 20; -fx-background-radius: 10;");

        this.getChildren().add(contenedor);
    }
}