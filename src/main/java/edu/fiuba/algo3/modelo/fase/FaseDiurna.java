package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.fase.faseData.FaseDiurnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.JugadorNulo;

public class FaseDiurna extends Fase{
    private Jugador revelado = new JugadorNulo();
    private Jugador sheriff = new JugadorNulo();

    public FaseDiurna(CriterioDeDesempate criterioDeDesempate){
        super();
        this.votacion = new Votacion(criterioDeDesempate);
    }

    public FaseDiurna(FaseDiurnaData info) {
        super();
        info.darReveladoPara(this);
        info.darReveladorPara(this);
        info.darCriterioPara(this);
        this.votacion = new Votacion(criterioDeDesempate);
    }

    public void setRevelado(Jugador revelado) {
        this.revelado = revelado;
    }
    public void setSheriff(Jugador sheriff){
        this.sheriff = sheriff;
    }
    public void setVotacion(CriterioDeDesempate criterioDeDesempate) {
        this.votacion = new Votacion(criterioDeDesempate);
    }

    public void ejecutar(Accion comando) {
        comando.execute();
    }

    public FaseDiurnaData exportarInfo(){
        return new FaseDiurnaData(votacion.obtenerMasVotado(), sheriff, revelado, criterioDeDesempate);
    }

    @Override
    public void registrarVoto(Jugador votante, Jugador objetivo) {
        this.votacion.registrarVoto(objetivo);
    }

    @Override
    public void cambiar(Partida partida) {
        partida.apilarData(exportarInfo());
        partida.hacerDeNoche();
    }

    public void revelar(Jugador revelador, Jugador revelado){
        revelado.revelarRolPara(this);
        this.sheriff = revelador;
    }
}
