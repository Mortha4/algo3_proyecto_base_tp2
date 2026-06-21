package edu.fiuba.algo3.vistas;
import edu.fiuba.algo3.vistas.utilidades.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.geometry.Pos;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ConfiguracionPartida {

    public static BorderPane crearVista() {

        BorderPane raiz = new BorderPane();
        raiz.setStyle("-fx-background-color: #F4F4F4;");

        Label titulo = new Label("Configuración de Partida");
        titulo.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");
        titulo.setPadding(new Insets(20, 0, 0, 0));


        VBox configuracion = new VBox(25);
        configuracion.setAlignment(Pos.CENTER);


        VBox seccionJugadores = new VBox(10);
        seccionJugadores.setAlignment(Pos.CENTER);

        Label lblJugadores = new Label("Cantidad de jugadores:");
        lblJugadores.setFont(new Font("Arial", 16));


        Spinner<Integer> cantidadJugadores = new Spinner<>(5, 12, 8);
        cantidadJugadores.setStyle("-fx-font-size: 14px;");

        seccionJugadores.getChildren().addAll(lblJugadores, cantidadJugadores);


        VBox seccionAvanzada = new VBox(10);
        seccionAvanzada.setAlignment(Pos.CENTER);
        seccionAvanzada.setStyle("-fx-border-color: #CCCCCC; -fx-border-width: 1; -fx-padding: 15; -fx-background-color: #FFFFFF;");
        seccionAvanzada.setMaxWidth(250); 

        Label lblAvanzada = new Label("Configuración Manual (Avanzado):");
        lblAvanzada.setFont(new Font("Arial", 12));
        lblAvanzada.setStyle("-fx-text-fill: #7F8C8D;");

        CheckBox mafia = new CheckBox("Incluir Mafia");
        mafia.setSelected(true);

        CheckBox detective = new CheckBox("Incluir Detective");
        detective.setSelected(true);

        CheckBox medico = new CheckBox("Incluir Médico");
        medico.setSelected(true);

        seccionAvanzada.getChildren().addAll(lblAvanzada, mafia, detective, medico);

        // --- BOTÓN DE ACCIÓN ---
        Button iniciar = new Button("Iniciar Partida");
        // Colores que contrastan y tamaño de área generoso
        iniciar.setStyle("-fx-font-size: 16px; -fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");
        iniciar.setMinSize(180, 45);

        // Ensamblado final
        configuracion.getChildren().addAll(
                seccionJugadores,
                seccionAvanzada,
                iniciar
        );

        raiz.setTop(titulo);
        BorderPane.setAlignment(titulo, Pos.CENTER);
        raiz.setCenter(configuracion);

        return raiz;
    }
}
