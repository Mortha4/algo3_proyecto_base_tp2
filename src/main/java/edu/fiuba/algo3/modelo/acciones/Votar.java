package edu.fiuba.algo3.modelo.acciones;
import edu.fiuba.algo3.modelo.excepciones.VotarAlMismoJugadorException;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Votar implements Accion {
    protected final Jugador objetivo;
    protected final Jugador votante;
    protected final Fase fase;

    public Votar(Fase fase, Jugador votante, Jugador objetivo) {
        if(votante.equals(objetivo)) {
            throw new VotarAlMismoJugadorException();
        }
        this.fase = fase;
        this.objetivo = objetivo;
        this.votante = votante;
    }

    @Override
    public void execute() {
        fase.registrarVoto(votante, objetivo);
    }
}
