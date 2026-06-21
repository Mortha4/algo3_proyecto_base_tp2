package edu.fiuba.algo3.vistas.utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Grilla {
    static final int COLUMNAS = 2;
    public static GridPane crearGrilla(int cantidadDeJugadores){
        GridPane grilla = new GridPane();
        grilla.setHgap(15);
        grilla.setVgap(15);
        grilla.setPadding(new Insets(15));
        grilla.setAlignment(Pos.CENTER);
        for(int i = 0; i < cantidadDeJugadores; i++){
            TarjetaDeJugador tarjeta = new TarjetaDeJugador ("Jugador "+ (i+1),"unRol");
            int columna = i%COLUMNAS;
            int fila = i/COLUMNAS;
            grilla.add(tarjeta, columna, fila);
        }
        return grilla;
    }
}
