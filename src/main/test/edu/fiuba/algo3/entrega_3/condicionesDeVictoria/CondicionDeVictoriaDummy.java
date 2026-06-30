package edu.fiuba.algo3.entrega_3.condicionesDeVictoria;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public class CondicionDeVictoriaDummy extends CondicionDeVictoria {
    public CondicionDeVictoriaDummy(List<Jugador> jugadores) {
        super(jugadores);
    }

    @Override
    protected Ganador chequearCondicion() {
        return null;
    }
}
