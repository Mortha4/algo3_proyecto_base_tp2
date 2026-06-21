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

        Scene escena = new Scene(Juego.verPartida(), 600, 720);
        stage.setTitle("Mafia");
        stage.setScene(escena);
        stage.show();              
        
        /*
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
        */
    }

   



    public static void main(String[] args) {
        launch();
    }

}