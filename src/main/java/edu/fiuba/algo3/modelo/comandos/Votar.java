package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Votar implements Command {
    private final Jugador objetivo;
    private final Fase fase;

    public Votar(Fase fase, Jugador votante, Jugador objetivo) {
        this.fase = fase;
        if((!objetivo.estaVivo()) || votante.equals(objetivo)) {
            throw new SeleccionInvalidaException();
        }
        this.objetivo = objetivo;
    }

    @Override
    public void execute() {
        fase.registrarVoto(objetivo);
    }
}
