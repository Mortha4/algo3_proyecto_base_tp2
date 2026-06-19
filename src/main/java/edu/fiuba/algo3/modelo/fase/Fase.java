package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.modelo.comandos.Command;
import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class Fase {
    protected Votacion votacion;
    Fase(){
        this.votacion = new Votacion();
    }

    public void ejecutar(Command comando) {
        comando.execute();
    }

    protected void otrasExcepciones(Candidato objetivo){}

    public void registrarVoto(Jugador objetivo) {
        this.votacion.registrarVoto(objetivo);
    }

    public void finalizar() {
        Candidato objetivo = this.votacion.obtenerMasVotado();

        if (!objetivo.estaVivo()) {
            throw new SeleccionInvalidaException();
        }
        otrasExcepciones(objetivo);

        objetivo.morir();
    }
}
