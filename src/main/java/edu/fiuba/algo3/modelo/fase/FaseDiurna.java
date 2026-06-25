package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.fase.faseData.FaseDiurnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.JugadorNulo;

public class FaseDiurna extends Fase{
    private Jugador revelado = new JugadorNulo();
    private Jugador sheriff = new JugadorNulo();

    public FaseDiurna(){
        super();
    }

    public FaseDiurna(FaseDiurnaData info) {
        super();
        info.darReveladoPara(this);
        info.darReveladorPara(this);
    }

    public void setRevelado(Jugador revelado) {
        this.revelado = revelado;
    }
    public void setSheriff(Jugador sheriff){
        this.sheriff = sheriff;
    }

    public void ejecutar(Accion comando) {
        comando.execute();
    }

    public FaseDiurnaData exportarInfo(){
        return new FaseDiurnaData(votacion.obtenerMasVotado(), sheriff, revelado);
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
