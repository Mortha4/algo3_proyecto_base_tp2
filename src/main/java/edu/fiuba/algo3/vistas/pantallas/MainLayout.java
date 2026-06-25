package edu.fiuba.algo3.vistas.pantallas;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MainLayout extends StackPane {
    private StackPane contentArea = new StackPane();

    public MainLayout() {

        ImageView background = new ImageView(new Image("/wallpaper.png"));
        background.setFitWidth(1920);
        background.setFitHeight(720);
        background.setPreserveRatio(false);

        this.getChildren().addAll(background, contentArea);
        setView(new ConfiguracionPartidaView());
    }


    public void setView(javafx.scene.Node view) {
        contentArea.getChildren().clear();
        contentArea.getChildren().add(view);
    }

    public void cambiarVentana(Node nuevaVista){
        this.setView(nuevaVista);
    }
}