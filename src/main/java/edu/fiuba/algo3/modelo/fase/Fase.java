package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public abstract class Fase {
    protected Votacion votacion;
    protected CriterioDeDesempate criterioDeDesempate;

    public abstract void ejecutar(Accion accion);
    public abstract FaseData exportarInfo();
    protected void excepcionesDeSentencia(Candidato objetivo){}

    public abstract Candidato obtenerMasVotado();

    public abstract void registrarVoto(Jugador votante, Jugador objetivo);
    public void obtenerMasVotados() {
        List<Candidato> objetivos = this.votacion.obtenerMasVotado();
        Candidato objetivo = criterioDeDesempate.desempatar(objetivos);
        excepcionesDeSentencia(objetivo);
        objetivo.morir();
    }

    public void nominar(Jugador nominador, Jugador nominado) {
        this.votacion.agregarCandidato(nominador, nominado);
    }
    public abstract void cambiar(Partida partida);
}
