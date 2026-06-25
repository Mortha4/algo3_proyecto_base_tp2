package edu.fiuba.algo3.controllers;



import edu.fiuba.algo3.modelo.mazo.*;

public class PartidaController {
    private static PartidaController instancia = new PartidaController();


    public static PartidaController instancia() { return instancia; }

    public void crearPartida(int cantidadJugadores) {

        try {
            Mazo mazo = new Mazo(cantidadJugadores);

        } catch (Exception e) {
            System.err.println("Error al crear el mazo: " + e.getMessage());
        }
    }

    public String obtenerRolDeJugador(int jugadorActual) {
        return "implementar";
    }
}