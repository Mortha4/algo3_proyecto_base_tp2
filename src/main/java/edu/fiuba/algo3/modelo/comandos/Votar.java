package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Votar implements Command {
    private final Jugador objetivo;
    private final FaseNocturna fase;

    public Votar(FaseNocturna fase, Jugador votante, Jugador objetivo) {
        this.fase = fase;
        if(!objetivo.estaVivo()) throw new SeleccionInvalidaException();

        this.objetivo = objetivo;
    }

    @Override
    public void execute() {
        fase.registrarVoto(objetivo);
    }
}
