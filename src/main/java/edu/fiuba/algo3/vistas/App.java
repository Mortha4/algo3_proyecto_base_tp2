package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.pantallas.ConfiguracionPartidaView;
import edu.fiuba.algo3.vistas.pantallas.MainLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static MainLayout root = new MainLayout();

    @Override
    public void start(Stage stage) {
        root.setView(new MainLayout());

        Scene escena = new Scene(root, 1920, 720);
        stage.setScene(escena);
        stage.show();
    }

    public static void cambiarVentana(javafx.scene.Node nuevaVista) {

        root.setView(nuevaVista);
    }

    public static void main(String[] args) {
        launch(args);
    }
}