package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class Fase {
    protected Votacion votacion;
    Fase(){
        this.votacion = new Votacion();
    }

    public abstract void ejecutar(Accion accion);
    public abstract FaseData exportarInfo();
    protected void otrasExcepciones(Candidato objetivo){}
    public abstract void registrarVoto(Jugador votante, Jugador objetivo);
    public void finalizar() {
        Candidato objetivo = this.votacion.obtenerMasVotado();
        otrasExcepciones(objetivo);
        objetivo.morir();
    }

    public void nominar(Jugador nominante, Jugador nominado) {
        this.votacion.agregarCandidato(nominante, nominado);
    }
}
