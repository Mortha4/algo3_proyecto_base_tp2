package edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GanaLaMafia;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public class UnSoloMafioso extends CondicionDeVictoria {
    public UnSoloMafioso(List<Jugador> jugadores) {
        super(jugadores);
    }

    @Override
    protected boolean condicion() {
        return cantidadDeMafiososVivos == 1 && cantidadDeCiudadanosVivos == 0;
    }

    @Override
    protected Ganador darGanador(List<Notificable> notificables) {
        return new GanaLaMafia(notificables);
    }
}
