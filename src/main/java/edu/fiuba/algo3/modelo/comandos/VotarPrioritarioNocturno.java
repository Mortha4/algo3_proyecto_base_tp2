package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VotarPrioritarioNocturno implements Command{
    private final Jugador objetivo;

    public VotarPrioritarioNocturno(Jugador objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public void execute(FaseNocturna faseNocturna) {
        faseNocturna.registrarVotoPrioritario(this.objetivo);
    }
}
