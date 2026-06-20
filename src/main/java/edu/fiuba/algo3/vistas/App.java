package edu.fiuba.algo3.vistas;

//import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;

//import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
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
        VBox zona = new VBox(crearGrilla(8));
        zona.setAlignment(Pos.CENTER);
        zona.setPadding(new Insets(20));
        zona.setStyle("-fx-background-color: #aed6f1;");
        return zona;
    }

    private GridPane crearGrilla(int cantidad){
        GridPane grilla = new GridPane();
        grilla.setHgap(15);
        grilla.setVgap(15);
        grilla.setPadding(new Insets(15));
        grilla.setAlignment(Pos.CENTER);
        for(int i = 0; i < cantidad; i++){
            TarjetaDeJugador tarjeta = new TarjetaDeJugador ("Jugador "+ (i+1),"unRol");
            int columna = i%2;
            int fila = i/2;
            grilla.add(tarjeta, columna, fila);
        }
        return grilla;
    }



    private VBox crearZonaInferior(String mensaje){
        Label mensajes = new Label(mensaje);

        HBox fila1 = Botones.crearFilaDeBotones("Cancelar", "Confirmar");
        HBox fila2 = Botones.crearFilaDeBotones("Boton1", "Boton2");
        HBox barraDeMensajes = new HBox(mensajes);
        barraDeMensajes.setAlignment(Pos.CENTER);
        barraDeMensajes.setPadding(new Insets(10));
        barraDeMensajes.setStyle("-fx-border-color #cccccc");
        
        VBox zona = new VBox(10,fila1,fila2, barraDeMensajes);
        zona.setPadding(new Insets(15));
        return zona;
    }



    public static void main(String[] args) {
        launch();
    }

}