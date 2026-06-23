package edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GanaLaMafia;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public class MayoriaDeMafiosos extends CondicionDeVictoria {
    public MayoriaDeMafiosos(List<Jugador> jugadores) {
        super(jugadores);
    }

    @Override
    protected Ganador chequearCondicion() {
        if(cantidadDeMafiososVivos >= cantidadDeCiudadanosVivos){
            return new GanaLaMafia();
        }
        return new NoHayGanador();
    }
}
