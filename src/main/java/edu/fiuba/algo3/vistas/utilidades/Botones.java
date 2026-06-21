package edu.fiuba.algo3.vistas.utilidades;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.geometry.Pos;

public class Botones{
    public static Button crearBoton(String texto, String estilo){
        Button boton = new Button(texto);
        cambiarColor(boton,estilo);
        return boton;
    }
    public static HBox crearFilaDeBotones(Button boton1,Button boton2){
        HBox fila = new HBox(10,boton1,boton2);
        fila.setAlignment(Pos.CENTER);

        HBox.setHgrow(boton1, Priority.ALWAYS);
        HBox.setHgrow(boton2, Priority.ALWAYS);
        boton1.setMaxWidth(270);
        boton2.setMaxWidth(270);
        return fila;
    }
    private static void cambiarColor(Button boton,String nombre){
        int pad = 15;  
        String fondo, borde, texto;
        switch (nombre) {
            case "rojo":
                fondo = "#f5d0d0"; 
                borde = "#d9a0a0"; 
                texto = "#333";
                break;
            case "verde":
                fondo = "#6aa84f"; 
                borde = "#d9a0a0"; 
                texto = "#fff";
                break;   
            case "amarillo":
                fondo = "#fdf2cc"; 
                borde = "#e6d28a"; 
                texto = "#333";
                break;
            case "azul":
                fondo = "#d6e4f5"; 
                borde = "#a9c5e8"; 
                texto = "#333";
                break;
            default:
                fondo = "#fff"; 
                borde = "#000"; 
                texto = "#000";
        }
      
        boton.setStyle(
            "-fx-background-color: " + fondo + ";" +
            "-fx-text-fill: " + texto + ";" +
            "-fx-font-weight: bold;" +
            "-fx-padding: " + pad + ";" +
            "-fx-border-color: " + borde + ";" +
            "-fx-border-width: 1;"
        );
    }
}