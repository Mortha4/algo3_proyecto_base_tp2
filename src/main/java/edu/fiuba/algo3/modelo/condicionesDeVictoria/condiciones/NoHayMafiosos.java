package edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GananLosCiudadanos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public class NoHayMafiosos extends CondicionDeVictoria {
    public NoHayMafiosos(List<Jugador> jugadores) {
        super(jugadores);
    }

    @Override
    protected boolean condicion() {
        return cantidadDeMafiososVivos == 0;
    }

    @Override
    protected Ganador darGanador(List<Notificable> notificables) {
        return new GananLosCiudadanos(notificables);
    }
}
