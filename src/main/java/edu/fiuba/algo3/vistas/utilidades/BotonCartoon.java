package edu.fiuba.algo3.vistas.utilidades; // O el paquete donde esté

import javafx.scene.control.Button; // ¡Importante!

// 1. Asegurate de poner el "extends Button"
public class BotonCartoon extends Button {

    public BotonCartoon(String texto) {
        // 2. Pasamos el texto al constructor del Button nativo
        super(texto);

        // Acá va tu lógica de estilos CSS para el botón cartoon...
    }
}
