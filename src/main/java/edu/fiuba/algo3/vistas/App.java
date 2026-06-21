package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.utilidades.*;
import edu.fiuba.algo3.vistas.Juego;
//import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

//import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Scene escena = new Scene(
                ConfiguracionPartida.crearVista(),
                600,
                720
        );
        stage.setTitle("configuracion ");
        stage.setScene(escena);
        stage.show();              


    }

   



    public static void main(String[] args) {
        launch();
    }

}