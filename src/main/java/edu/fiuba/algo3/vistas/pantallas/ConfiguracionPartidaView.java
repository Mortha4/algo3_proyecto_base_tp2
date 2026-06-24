package edu.fiuba.algo3.vistas.pantallas;

import edu.fiuba.algo3.vistas.Juego;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import edu.fiuba.algo3.vistas.utilidades.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ConfiguracionPartidaView extends StackPane {


    public ConfiguracionPartidaView() {


        ImageView background = new ImageView(new Image("/menuConfig.png"));
        background.setFitWidth(600);
        background.setFitHeight(720);
        background.setPreserveRatio(false);

        VBox loyout = new VBox(-70);
        loyout.setAlignment(Pos.BOTTOM_CENTER);




        // Botón
        ContadorJugadores btn1 = new ContadorJugadores();

        BotonRolMafioso btn0= new BotonRolMafioso();
        BotonRolMedico btn2 = new BotonRolMedico();
        BotonRolDetective btn3 = new BotonRolDetective();
        BotonGuardar btnSave = new BotonGuardar(200);

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
}