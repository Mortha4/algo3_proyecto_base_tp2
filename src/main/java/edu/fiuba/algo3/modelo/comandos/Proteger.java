package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Proteger implements Command {
    private final Jugador objetivo;

    public Proteger(Jugador objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public void execute(FaseNocturna faseNocturna) {
        faseNocturna.proteger(this.objetivo);
    }
}
