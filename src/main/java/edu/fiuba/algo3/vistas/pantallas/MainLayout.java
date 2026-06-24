package edu.fiuba.algo3.vistas.pantallas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MainLayout extends StackPane {
    private StackPane contentArea = new StackPane();

    public MainLayout() {
        // 1. Imagen de fondo estática
        ImageView background = new ImageView(new Image("/wallpaper.png"));
        background.setFitWidth(1920);
        background.setFitHeight(720);
        background.setPreserveRatio(false);

        ConfiguracionPartidaView config = new ConfiguracionPartidaView();

        // 2. Agregamos el fondo y el área de contenido
        this.getChildren().addAll(background,config);
    }


    public void setView(javafx.scene.Node view) {
        contentArea.getChildren().clear();
        contentArea.getChildren().add(view);
    }
}