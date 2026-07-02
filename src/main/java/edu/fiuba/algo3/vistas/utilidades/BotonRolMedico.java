package edu.fiuba.algo3.vistas.utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Objects;

public class BotonRolMedico extends StackPane {
    public BotonRolMedico(){

        Image imgPergamino = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/rolMedico.png")));
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
        StackPane.setMargin(boton, new Insets(-6, -2, 0, 0));


        this.getChildren().addAll(vistaPergamino,boton);
    }


}
