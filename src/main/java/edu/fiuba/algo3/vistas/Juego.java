package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.utilidades.*;
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


public class Juego {
    public static BorderPane verPartida(){
        BorderPane raiz = new BorderPane();
        raiz.setTop(crearZonaSuperior("Fase Actual"));
        raiz.setCenter(crearZonaCentral());
        raiz.setBottom(crearZonaInferior("Mensajes y botones"));
        return raiz;
    }

    private static VBox crearZonaSuperior(String mensaje){
        Label faseActual = new Label("Fase Actual");
        faseActual.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        VBox zona = new VBox(faseActual);
        zona.setAlignment(Pos.CENTER);
        zona.setPadding(new Insets(15));
        zona.setStyle("-fx-border-color: #cccccc;");
        return zona;
    }

    private static VBox crearZonaCentral(){
        VBox zona = new VBox(Grilla.crearGrilla(8));
        zona.setAlignment(Pos.CENTER);
        zona.setPadding(new Insets(20));
        zona.setStyle("-fx-background-color: #aed6f1;");
        return zona;
    }

    private static VBox crearZonaInferior(String mensaje){
        Label mensajes = new Label(mensaje);

        HBox fila1 = Botones.crearFilaDeBotones ("Cancelar", "Confirmar");
        HBox fila2 = Botones.crearFilaDeBotones("Boton1", "Boton2");
        HBox barraDeMensajes = new HBox(mensajes);
        barraDeMensajes.setAlignment(Pos.CENTER);
        barraDeMensajes.setPadding(new Insets(10));
        barraDeMensajes.setStyle("-fx-border-color #cccccc");
        
        VBox zona = new VBox(10,fila1,fila2, barraDeMensajes);
        zona.setPadding(new Insets(15));
        return zona;
    }

/*     private HBox botones(){
        Button cancelar = Botones.crearBoton("Cancelar", "rojo");
        Button confirmar = Botones.crearBoton("Confirmar", "verde");
        Hbox fila1 = 

    } */

}
