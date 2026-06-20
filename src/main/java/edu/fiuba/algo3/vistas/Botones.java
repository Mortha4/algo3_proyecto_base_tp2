package edu.fiuba.algo3.vistas;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.geometry.Pos;

public class Botones{
    public static HBox crearFilaDeBotones(String nombreBoton1,String nombreBoton2){
        Button boton1 = new Button(nombreBoton1);
        Button boton2 = new Button(nombreBoton2);
        HBox fila = new HBox(10,boton1,boton2);
        fila.setAlignment(Pos.CENTER);

        HBox.setHgrow(boton1, Priority.ALWAYS);
        HBox.setHgrow(boton2, Priority.ALWAYS);
        boton1.setMaxWidth(Double.MAX_VALUE);
        boton2.setMaxWidth(Double.MAX_VALUE);
        return fila;
    }
}
