package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VotarPrioritarioNocturno implements Command{
    private final Jugador objetivo;
    private final FaseNocturna fase;

    public VotarPrioritarioNocturno(FaseNocturna fase, Jugador base, Jugador objetivo) {
        this.fase = fase;
        this.objetivo = objetivo;
    }

    @Override
    public void execute() {
        fase.registrarVotoPrioritario(objetivo);
    }
}
