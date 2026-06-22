package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Investigar implements AccionNocturna {
    private final FaseNocturna fase;
    private final Jugador jugadorBase;
    private final Jugador objetivo;

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
