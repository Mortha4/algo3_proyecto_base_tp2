package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.controllers.PartidaController;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.*;
import edu.fiuba.algo3.vistas.utilidades.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ConfiguracionPartidaView extends StackPane {

    private int contadorJugadores= 5;
    private ContadorJugadores btn1;
    private PartidaController partida;


    public ConfiguracionPartidaView() {


        ImageView background = new ImageView(new Image("/menuConfig.png"));
        background.setFitWidth(600);
        background.setFitHeight(720);
        background.setPreserveRatio(false);

        VBox loyout = new VBox(-70);
        loyout.setAlignment(Pos.BOTTOM_CENTER);




        // Botón
        btn1 = new ContadorJugadores();

        BotonRolMafioso btn0= new BotonRolMafioso();
        BotonRolMedico btn2 = new BotonRolMedico();
        BotonRolDetective btn3 = new BotonRolDetective();
        BotonGuardar btnSave = new BotonGuardar(200);

        btnSave.setOnActionGuardar(() -> {
            ejecutarGuardado();
        });

        VBox espaciador = new VBox(-270);
        espaciador.setAlignment(Pos.TOP_CENTER);



        // VBox con botones centrados
        VBox menuBox = new VBox(-50);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.getChildren().addAll(btn1);

        VBox roles = new VBox(-140);
        roles.setAlignment(Pos.CENTER);

        roles.getChildren().addAll(btn0,btn2,btn3);

        VBox opciones = new VBox(-10);
        opciones.setAlignment(Pos.BOTTOM_CENTER);
        opciones.getChildren().addAll(btnSave);


        loyout.getChildren().addAll(espaciador,menuBox,roles,opciones);


        this.getChildren().addAll(background,loyout);
    }


    private void ejecutarGuardado() {
        int cantidadJugadores = btn1.getCantidad();

        partida.instancia().crearPartida(cantidadJugadores);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Configuración Guardada");
        alert.setHeaderText(null);
        alert.setContentText("La partida ha sido configurada con " + cantidadJugadores + " jugadores.");


        alert.showAndWait();
    }
}