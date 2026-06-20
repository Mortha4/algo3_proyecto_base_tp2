package edu.fiuba.algo3.vistas;

//import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;

//import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane raiz = new BorderPane();

        Label faseActual = new Label("Fase Actual");
        faseActual.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        VBox zonaSuperior = new VBox(faseActual);
        zonaSuperior.setAlignment(Pos.CENTER);
        zonaSuperior.setPadding(new Insets(15));
        zonaSuperior.setStyle("-fx-border-color: #cccccc;");
        raiz.setTop(zonaSuperior);

        Label placeholderCentro = new Label("(tarjetas de jugador)");
        VBox zonaCentral = new VBox(placeholderCentro);
        zonaCentral.setAlignment(Pos.CENTER);
        zonaCentral.setStyle("-fx-background-color: #aed6f1;");
        raiz.setCenter(zonaCentral);

        Label placeholderAbajo = new Label("(botones y mensajes)");
        VBox zonaInferior = new VBox(placeholderAbajo);
        zonaInferior.setAlignment(Pos.CENTER);
        zonaInferior.setPadding(new Insets(15));
        zonaInferior.setStyle("-fx-border-color: #cccccc");
        raiz.setBottom(zonaInferior);
        
        Scene escena = new Scene(raiz, 600, 720);
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