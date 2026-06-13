package edu.fiuba.algo3.modelo.votacion;
import edu.fiuba.algo3.modelo.AccionNocturnaCommand;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//public class Voto implements AccionNocturnaCommand {
public class Voto {
    /*private final Jugador jugador;*/
    private final Jugador objetivo;
    // private final Votacion receptor;

    /*public Voto(Votacion votacion, Jugador objetivo){
        this.receptor = votacion;
        this.objetivo = objetivo;
    }*/

    /*@Override
    public void ejecutar() {
        receptor.votar(objetivo);
    }*/

    public Voto(/*Jugador jugador,*/ Jugador objetivo) {
        /*this.jugador = jugador;*/
        this.objetivo = objetivo;
    }

    public Jugador obtenerJugadorVotado() {
        return this.objetivo;
    }
}
