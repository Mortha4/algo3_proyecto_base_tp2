package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Proteger implements Command {
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
