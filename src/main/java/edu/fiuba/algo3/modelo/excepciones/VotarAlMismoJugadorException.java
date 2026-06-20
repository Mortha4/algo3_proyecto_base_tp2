package edu.fiuba.algo3.modelo.excepciones;

public class VotarAlMismoJugadorException extends SeleccionInvalidaException {
    public VotarAlMismoJugadorException() {
        super("Un jugador no puede votarse a sí mismo.");
    }
}