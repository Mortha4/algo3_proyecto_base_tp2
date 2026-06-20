package edu.fiuba.algo3.modelo.excepciones;

public class VotarMismoRolException extends SeleccionInvalidaException{

    public VotarMismoRolException() {
        super("No se puede votar a un jugador con el mismo rol durante la noche.");
    }
}
