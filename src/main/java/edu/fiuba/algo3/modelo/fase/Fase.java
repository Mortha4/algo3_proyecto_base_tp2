package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class Fase {
    protected Votacion votacion;
    protected CriterioDeDesempate criterioDeDesempate;

    public abstract void ejecutar(Accion accion);
    public abstract FaseData exportarInfo(Candidato objetivo);
    public abstract void registrarVoto(Jugador votante, Jugador objetivo);
    public abstract void finalizar(Partida partida);
    public void nominar(Jugador nominador, Jugador nominado) {
        this.votacion.agregarCandidato(nominador, nominado);
    }
}
