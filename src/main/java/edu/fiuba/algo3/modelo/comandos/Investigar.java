package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Investigar implements Command {
    private FaseNocturna fase;
    private Jugador jugadorBase;
    private Jugador objetivo;

    public Investigar(FaseNocturna fase, Jugador base, Jugador objetivo){
        this.fase = fase;
        this.jugadorBase = base;
        this.objetivo = objetivo;
    }

    @Override
    public void execute() {
        fase.investigar(jugadorBase, objetivo);
    }
}
