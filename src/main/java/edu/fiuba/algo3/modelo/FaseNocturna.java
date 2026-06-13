package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoProtegidoException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.votacion.Votacion;

import java.util.List;

public class FaseNocturna {
    private List<Jugador> jugadores;
    private final Votacion votacionMafia;
    private Jugador protegido;

    public FaseNocturna(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.votacionMafia = new Votacion();
    }

    // comando votar ()
    /*
    * void registrarVoto(Jugador objetivo) {
    *   this.votacionMafia.registrarVoto(objetivo);
    * }
    * */
    /*
     * void registrarVotoPrioritario(Jugador objetivo) {
     *   this.votacionMafia.registrarVotoPrioritario(objetivo);
     * }
     * */

    public void laMafiaElige(Jugador objetivo) {
        if (!objetivo.estaVivo()) {
            throw new SeleccionInvalidaException();
        }

        this.votacionMafia.registrarVoto(objetivo);
    }

    public void elMedicoProtege(Jugador objetivo){
        this.protegido = objetivo;
    }

    public void finalizar() {
        Jugador objetivo = this.votacionMafia.obtenerMasVotado();
        if(objetivo == null){
            throw new NoHuboDecisionException();
        } else if (objetivo.equals(this.protegido)){
            throw new ObjetivoProtegidoException();
        }
        objetivo.morir();
    }

}
