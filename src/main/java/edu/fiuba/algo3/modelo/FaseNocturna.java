package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalida;

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
        if (!objetivo.estaVivo()) {
            throw new SeleccionInvalida("La mafia seleccionó una víctima invalida");
        }

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
