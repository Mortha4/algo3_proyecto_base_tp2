package edu.fiuba.algo3.modelo.excepciones;

public class AccionSobreUnoMismoException extends RuntimeException {
    public AccionSobreUnoMismoException(String message) {
        super(message);
    }

    public AccionSobreUnoMismoException() {
        super("No podés aplicar esta acción sobre vos mismo.");
    }


}
