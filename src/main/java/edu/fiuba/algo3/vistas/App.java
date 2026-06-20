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
        raiz.setTop(crearZonaSuperior("Fase Actual"));
        raiz.setCenter(crearZonaCentral());
        raiz.setBottom(crearZonaInferior("Mensajes y botones"));
        
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

    private VBox crearZonaSuperior(String mensaje){
        Label faseActual = new Label("Fase Actual");
        faseActual.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        VBox zona = new VBox(faseActual);
        zona.setAlignment(Pos.CENTER);
        zona.setPadding(new Insets(15));
        zona.setStyle("-fx-border-color: #cccccc;");
        return zona;
    }

    private VBox crearZonaCentral(){
        TarjetaDeJugador tarjeta = new TarjetaDeJugador("UnNombre", "UnRol");
        VBox zona = new VBox(tarjeta);
        zona.setAlignment(Pos.CENTER);
        zona.setPadding(new Insets(20));
        zona.setStyle("-fx-background-color: #aed6f1;");
        return zona;
    }

    private VBox crearZonaInferior(String mensaje){
        Label placeholderAbajo = new Label(mensaje);
        VBox zona = new VBox(placeholderAbajo);
        zona.setAlignment(Pos.CENTER);
        zona.setPadding(new Insets(15));
        zona.setStyle("-fx-border-color: #cccccc");
        return zona;
    }



    public static void main(String[] args) {
        launch();
    }

}