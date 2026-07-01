package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class Fase {
    protected Votacion votacion;
    Fase(){
        this.votacion = new Votacion();
    }

    public abstract void ejecutar(Accion accion);
    public abstract FaseData exportarInfo();
    protected void excepcionesDeSentencia(Candidato objetivo){}
    public abstract void registrarVoto(Jugador votante, Jugador objetivo);
    public void finalizar() {
        Candidato objetivo = this.votacion.obtenerMasVotado();
        excepcionesDeSentencia(objetivo);
        objetivo.morir();
    }

    public void nominar(Jugador nominante, Jugador nominado) {
        this.votacion.agregarCandidato(nominante, nominado);
    }

    public abstract void cambiar(Partida partida);

}
