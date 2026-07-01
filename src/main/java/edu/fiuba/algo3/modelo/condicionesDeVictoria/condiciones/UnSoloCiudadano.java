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

    @Override
    protected void chequearCondicion(List<Notificable> notificables) {
        Ganador ganador;
        if(cantidadDeCiudadanosVivos == 1 && cantidadDeMafiososVivos == 0){
            ganador = new GananLosCiudadanos(notificables);
        } else {
            ganador = new NoHayGanador(notificables);
        }
        ganador.anunciar();
    }
}
