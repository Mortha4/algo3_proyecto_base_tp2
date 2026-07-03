package edu.fiuba.algo3.vistas.utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Grilla {
    public static GridPane crearGrilla(int cantidadDeJugadores){
        
        int columnas = cantidadDeJugadores < 9 ? 2 : 3;
        GridPane grilla = new GridPane();
        grilla.setHgap(15);
        grilla.setVgap(15);
        grilla.setPadding(new Insets(15));
        grilla.setAlignment(Pos.CENTER);
        for(int i = 0; i < cantidadDeJugadores; i++){
            TarjetaDeJugador tarjeta = new TarjetaDeJugador ("Jugador "+ (i+1),"unRol",cantidadDeJugadores);
            int columna = i%columnas;
            int fila = i/columnas;
            grilla.add(tarjeta, columna, fila);
        }
        return grilla;
    }
}
