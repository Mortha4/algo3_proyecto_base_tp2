package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.controllers.PartidaController;
import edu.fiuba.algo3.vistas.App;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.*;
import edu.fiuba.algo3.vistas.utilidades.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ConfiguracionPartidaView extends StackPane {

    private int contadorJugadores= 5;
    private PartidaController partida;


    public ConfiguracionPartidaView() {


        ImageView background = new ImageView(new Image("/menuConfig.png"));
        background.setFitWidth(600);
        background.setFitHeight(720);
        background.setPreserveRatio(false);

        VBox loyout = new VBox(-70);
        loyout.setAlignment(Pos.BOTTOM_CENTER);


        // Botón
        BotonRolMedico boton1 = new BotonRolMedico();
        BotonRolDetective boton2 = new BotonRolDetective();
        BotonRolSheriff boton3 = new BotonRolSheriff();
        BotonRolPadrino boton4 = new BotonRolPadrino();

        BotonGuardar botonSave = new BotonGuardar(200);
        BotonVolver botonBack = new BotonVolver(100) ;

        botonSave.setOnActionGuardar(() -> {
            ejecutarGuardado();
            App.cambiarVentana(new SeleccionJugadoresView());

        });

        botonBack.setOnAction( (P) -> {
            App.cambiarVentana(new SeleccionJugadoresView());
        });

        VBox espaciador = new VBox(-270);
        espaciador.setAlignment(Pos.TOP_CENTER);



        // VBox con botones centrados
        VBox menuBox = new VBox(-50);
        menuBox.setAlignment(Pos.CENTER);

        VBox roles = new VBox(-140);
        roles.setAlignment(Pos.CENTER);

        roles.getChildren().addAll(boton1,boton2,boton3,boton4);

        VBox opciones = new VBox(-10);
        opciones.setAlignment(Pos.BOTTOM_CENTER);
        opciones.getChildren().addAll(botonSave,botonBack);

        loyout.getChildren().addAll(espaciador,menuBox,roles,opciones);


        this.getChildren().addAll(background,loyout);
    }


    private void ejecutarGuardado() {


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Configuración Guardada");
        alert.setHeaderText(null);
        alert.setContentText("Guardado exitoso");


        alert.showAndWait();
    }
}