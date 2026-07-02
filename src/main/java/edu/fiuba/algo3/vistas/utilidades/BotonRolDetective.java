package edu.fiuba.algo3.vistas.utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class BotonRolDetective extends StackPane {
    public BotonRolDetective(){

        Image imgPergamino = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/rolDetective.png")));
        ImageView vistaPergamino = new ImageView(imgPergamino);

        //tamaños
        double anchoCaja = 340;
        vistaPergamino.setFitWidth(anchoCaja);
        vistaPergamino.setPreserveRatio(true); // Evita que se deforme o rote de forma extraña
        vistaPergamino.setSmooth(false);
        this.setMaxWidth(anchoCaja);
        this.setAlignment(Pos.CENTER);


        BotonSwitch boton = new BotonSwitch();
        StackPane.setAlignment(boton, Pos.CENTER_RIGHT);
        StackPane.setMargin(boton, new Insets(-12, 1, 0, 0));

        this.getChildren().addAll(vistaPergamino,boton);
    }


}
