package edu.fiuba.algo3.vistas.utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BotonRolMafioso extends StackPane {

    private int cantidad;

    public BotonRolMafioso(){

        Image imgPergamino = new Image(getClass().getResourceAsStream("/rolMafioso.png"));
        ImageView vistaPergamino = new ImageView(imgPergamino);

        //tamaños
        double anchoCaja = 340;
        vistaPergamino.setFitWidth(anchoCaja);
        vistaPergamino.setPreserveRatio(true); // Evita que se deforme o rote de forma extraña
        vistaPergamino.setSmooth(false);
        this.setMaxWidth(anchoCaja);
        this.setAlignment(Pos.CENTER);



        //espaciadores
        Region espaciadorIzquierdo = new Region();
        HBox.setHgrow(espaciadorIzquierdo, Priority.ALWAYS);

        Region espaciadorDerecho = new Region();
        HBox.setHgrow(espaciadorDerecho, Priority.ALWAYS);


        //contenido

        HBox controles = new HBox(30);
        controles.setAlignment(Pos.CENTER);
        controles.setPadding(new Insets(12, 30, 0, 22));

        controles.getChildren().addAll(espaciadorIzquierdo,espaciadorDerecho);

        this.getChildren().addAll(vistaPergamino,controles);
    }




}
