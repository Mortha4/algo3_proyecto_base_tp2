package edu.fiuba.algo3.modelo;
import java.util.List;

public class FaseNocturna {
    private List<Jugador> jugadores;
    private Votacion votacionMafia;
    private Jugador protegido;

    public FaseNocturna(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.votacionMafia = new Votacion();
    }

    public void laMafiaElije(Jugador objetivo) {
        this.votacionMafia.votar(objetivo);
    }

    public void elMedicoProteje(Jugador objetivo){
        this.protegido = objetivo;
    }

    public void finalizar() {
        Jugador objetivo = this.votacionMafia.obtenerMasVotado();
        if(objetivo == null || objetivo.equals(this.protegido)){
            return;
        }
        objetivo.eliminar();
    }

}
