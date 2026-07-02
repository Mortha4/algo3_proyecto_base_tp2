package edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GananLosCiudadanos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public class UnSoloCiudadano extends CondicionDeVictoria {
    public UnSoloCiudadano(List<Jugador> jugadores) {
        super(jugadores);
    }

    protected Ganador darGanador(List<Notificable> notificables){
        return new GananLosCiudadanos(notificables);
    }
    protected boolean condicion(){
        return cantidadDeCiudadanosVivos == 1 && cantidadDeMafiososVivos == 0;
    }
}
