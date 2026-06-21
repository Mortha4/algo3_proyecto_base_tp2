package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.pantallas.ConfiguracionPartidaView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        ConfiguracionPartidaView pantallaConfig = new ConfiguracionPartidaView(stage);
        Scene escena = new Scene(pantallaConfig, 600, 720);
        //Scene escena = new Scene(Juego.verPartida(), 600, 720);

        stage.setTitle("Configuración de Partida");
        stage.setScene(escena);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}