package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VotarPrioritario implements AccionNocturna {
    private final Jugador objetivo;
    private final Jugador votante;
    private final FaseNocturna fase;

    public VotarPrioritario(FaseNocturna fase, Jugador votante, Jugador objetivo) {
        if( votante.equals(objetivo)) {
            throw new SeleccionInvalidaException();
        }
        this.fase = fase;
        this.objetivo = objetivo;
        this.votante = votante;
    }

    @Override
    public void execute() {
        fase.registrarVotoPrioritario(votante, objetivo);
    }
}
