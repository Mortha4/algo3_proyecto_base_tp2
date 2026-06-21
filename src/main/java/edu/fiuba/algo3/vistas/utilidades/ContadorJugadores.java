package edu.fiuba.algo3.vistas.utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class ContadorJugadores extends StackPane {

    private int cantidad;

    public ContadorJugadores(){

        Image imgPergamino = new Image(getClass().getResourceAsStream("/contador.png"));
        ImageView vistaPergamino = new ImageView(imgPergamino);

        double anchoCaja = 340;
        vistaPergamino.setFitWidth(anchoCaja);
        vistaPergamino.setPreserveRatio(true); // Evita que se deforme o rote de forma extraña
        vistaPergamino.setSmooth(false);
        this.setMaxWidth(anchoCaja);
        this.setAlignment(Pos.CENTER);

        //logica boton menos


        //contenido

        HBox controles = new HBox(30);
        controles.setAlignment(Pos.CENTER);
        controles.setPadding(new Insets(45, 0, 0, 0));


        this.getChildren().addAll(vistaPergamino);
    }





}
