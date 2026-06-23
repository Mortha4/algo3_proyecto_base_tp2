package edu.fiuba.algo3.vistas.utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ContadorJugadores extends StackPane {

    private final Text txtCantidad;
    private int cantidad=5;

    public ContadorJugadores(){

        Image imgPergamino = new Image(getClass().getResourceAsStream("/contador.png"));
        ImageView vistaPergamino = new ImageView(imgPergamino);

        //tamaños
        double anchoCaja = 340;
        vistaPergamino.setFitWidth(anchoCaja);
        vistaPergamino.setPreserveRatio(true); // Evita que se deforme o rote de forma extraña
        vistaPergamino.setSmooth(false);
        this.setMaxWidth(anchoCaja);
        this.setAlignment(Pos.CENTER);

        //botones
        BotonAgregar btnAdd = new BotonAgregar();
        BotonRestar btnRes = new BotonRestar();

        //texto dinamico

        this.txtCantidad = new Text(String.valueOf(this.cantidad));
        this.txtCantidad.setStyle("-fx-font-size: 34px; -fx-font-weight: bold; -fx-fill: #ffcc00;");
        this.txtCantidad.setFont(
                Font.loadFont(
                        getClass().getResourceAsStream("/fonts/PIXELITE.ttf"),
                        34
                )
        );


        StackPane contenedorTexto = new StackPane(this.txtCantidad);
        contenedorTexto.setPrefWidth(80);

        this.txtCantidad.setFill(Color.web("#F2B55B"));
        this.txtCantidad.setStroke(Color.web("#D18B47"));
        this.txtCantidad.setStrokeWidth(2);
        DropShadow sombra = new DropShadow();
        sombra.setRadius(0);
        sombra.setOffsetX(4);
        sombra.setOffsetY(4);
        sombra.setColor(Color.BLACK);

        this.txtCantidad.setEffect(sombra);



        btnAdd.accionSumar(() -> {
            if (this.cantidad < 12) {
                this.cantidad++;
                actualizarPantalla();
            }
        });

        btnRes.accionRestar(() -> {
            if (this.cantidad > 5) {
                this.cantidad--;
                actualizarPantalla();
            }
        });


        //espaciadores
        Region espaciadorIzquierdo = new Region();
        HBox.setHgrow(espaciadorIzquierdo, Priority.ALWAYS);

        Region espaciadorDerecho = new Region();
        HBox.setHgrow(espaciadorDerecho, Priority.ALWAYS);


        //contenido

        HBox controles = new HBox(5);
        controles.setAlignment(Pos.CENTER);
        controles.setPadding(new Insets(12, 22, 0, 20));

        controles.getChildren().addAll(btnRes,espaciadorIzquierdo,contenedorTexto,espaciadorDerecho,btnAdd);


        this.getChildren().addAll(vistaPergamino,controles);
    }


    private void actualizarPantalla(){
        this.txtCantidad.setText(String.valueOf(this.cantidad));
    }



}