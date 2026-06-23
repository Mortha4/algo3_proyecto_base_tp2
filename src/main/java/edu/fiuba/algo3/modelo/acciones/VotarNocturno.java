package edu.fiuba.algo3.modelo.acciones;
import edu.fiuba.algo3.modelo.excepciones.VotacionEntreMafiososException;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VotarNocturno extends Votar implements Accion{
    public VotarNocturno(Fase fase, Jugador votante, Jugador objetivo) {
        super(fase, votante, objetivo);
        if (votante.tieneMismoRol(objetivo)) {
            throw new VotacionEntreMafiososException();
        }
    }
}
