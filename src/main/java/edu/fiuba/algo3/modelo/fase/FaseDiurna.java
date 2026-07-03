package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.fase.faseData.FaseDiurnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.JugadorNulo;
import java.util.Set;

public class FaseDiurna extends Fase{
    private Jugador revelado = new JugadorNulo();
    private Jugador sheriff = new JugadorNulo();

    public FaseDiurna(CriterioDeDesempate criterioDeDesempate){
        super();
        this.votacion = new Votacion();
        this.criterioDeDesempate = criterioDeDesempate;
    }

    public FaseDiurna(FaseDiurnaData info) {
        super();
        info.darReveladoPara(this);
        info.darReveladorPara(this);
        info.darCriterioPara(this);
        this.votacion = new Votacion();
    }

    public void setRevelado(Jugador revelado) {
        this.revelado = revelado;
    }
    public void setSheriff(Jugador sheriff){
        this.sheriff = sheriff;
    }
    public void setCriterio(CriterioDeDesempate criterioDeDesempate) {
        this.criterioDeDesempate = criterioDeDesempate;
    }

    public void ejecutar(Accion comando) {
        comando.execute();
    }

    public FaseDiurnaData exportarInfo(Candidato objetivo){
        return new FaseDiurnaData(objetivo, sheriff, revelado, criterioDeDesempate);
    }

    @Override
    public void registrarVoto(Jugador votante, Jugador objetivo) {
        this.votacion.registrarVoto(objetivo);
    }

    @Override
    public void finalizar(Partida partida) {
        Set<Candidato> masVotados = votacion.obtenerMasVotado();

        if (masVotados.size() > 1) {
            partida.hacerBallotage(masVotados, criterioDeDesempate, sheriff, revelado);
            return;
        }

        Candidato objetivo = criterioDeDesempate.desempatar(masVotados);
        objetivo.morir();
        partida.apilarData(exportarInfo(objetivo));
        partida.hacerDeNoche();
    }

    public void revelar(Jugador revelador, Jugador revelado){
        revelado.revelarRolPara(this);
        this.sheriff = revelador;
    }
}
