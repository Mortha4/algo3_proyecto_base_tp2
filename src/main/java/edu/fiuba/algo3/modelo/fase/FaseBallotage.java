package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.fase.faseData.FaseDiurnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.partida.Partida;
import java.util.Set;

public class FaseBallotage extends Fase{
    Jugador sheriff;
    Jugador revelado;

    public FaseBallotage(
            Set<Candidato> empatados,
            CriterioDeDesempate criterio,
            Jugador sheriff,
            Jugador revelado) {

        this.criterioDeDesempate = criterio;
        this.sheriff = sheriff;
        this.revelado = revelado;
        this.votacion = new Votacion(empatados);
    }

    @Override
    public void ejecutar(Accion comando) {
        comando.execute();
    }

    @Override
    public FaseDiurnaData exportarInfo(Candidato objetivo) {
        return new FaseDiurnaData(objetivo, sheriff, revelado, criterioDeDesempate);
    }

    @Override
    public void registrarVoto(Jugador votante, Jugador objetivo) {
        this.votacion.registrarVoto(objetivo);
    }

    @Override
    public void finalizar(Partida partida) {
        Set<Candidato> masVotados = votacion.obtenerMasVotado();
        Candidato objetivo = criterioDeDesempate.desempatar(masVotados);
        objetivo.morir();
        partida.apilarData(exportarInfo(objetivo));
        partida.hacerDeNoche();
    }

    @Override
    public void nominar(Jugador nominador, Jugador nominado) {}
}
