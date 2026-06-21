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

public class ContadorJugadores extends StackPane {

    private final Text txtCantidad;
    private int cantidad;

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

        this.txtCantidad = new Text(String.valueOf(5));

        Font fuentePixel = Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P.ttf"), 40);

        if (fuentePixel != null) {
            this.txtCantidad.setFont(fuentePixel);
        }

        this.txtCantidad.setStyle(
                "-fx-fill: #bfa16f;" + // Color beige/naranja mate de la madera
                        "-fx-stroke: #2b1a08;" + // Borde oscuro
                        "-fx-stroke-width: 1px;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 0, 0, 0, 3);" // Relieve de hundido
        );

        StackPane contenedorNumero = new StackPane(this.txtCantidad);
        contenedorNumero.setAlignment(Pos.CENTER);
        contenedorNumero.setMinWidth(110);
        contenedorNumero.setMaxWidth(110);
        contenedorNumero.setPrefWidth(110);

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

        HBox controles = new HBox(30);
        controles.setAlignment(Pos.CENTER);
        controles.setPadding(new Insets(12, 30, 0, 22));

        controles.getChildren().addAll(espaciadorIzquierdo,btnRes,contenedorNumero,btnAdd,espaciadorDerecho);

        this.getChildren().addAll(vistaPergamino,controles);
    }


    private void actualizarPantalla(){
        this.txtCantidad.setText(String.valueOf(this.cantidad));
    }


}
