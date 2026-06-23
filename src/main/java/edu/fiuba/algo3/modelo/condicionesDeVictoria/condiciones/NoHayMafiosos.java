package edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GananLosCiudadanos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public class NoHayMafiosos extends CondicionDeVictoria {
    public NoHayMafiosos(List<Jugador> jugadores) {
        super(jugadores);
    }

    @Override
    protected Ganador chequearCondicion() {
        if(cantidadDeMafiososVivos == 0){
            return new GananLosCiudadanos();
        }
        return new NoHayGanador();
    }
}
