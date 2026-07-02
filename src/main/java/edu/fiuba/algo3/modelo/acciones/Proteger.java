package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Proteger implements Accion {
    private final Jugador objetivo;
    private final FaseNocturna faseNocturna;

    public Proteger(FaseNocturna faseNocturna, Jugador objetivo) {
        this.faseNocturna = faseNocturna;
        this.objetivo = objetivo;
    }

    @Override
    public void execute() {
        faseNocturna.proteger(this.objetivo);
    }
}
