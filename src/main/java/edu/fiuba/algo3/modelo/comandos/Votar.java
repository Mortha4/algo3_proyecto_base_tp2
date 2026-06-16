package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Votar implements Command {
    private final Jugador objetivo;

    public Votar(Jugador votante, Jugador objetivo) {
        if(!objetivo.estaVivo()) throw new SeleccionInvalidaException();

        this.objetivo = objetivo;
    }

    @Override
    public void execute(FaseNocturna faseNocturna) {
        faseNocturna.registrarVoto(this.objetivo);
    }
}
