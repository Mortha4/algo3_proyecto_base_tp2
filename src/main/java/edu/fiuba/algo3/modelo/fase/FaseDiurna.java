package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FaseDiurna extends Fase{

    public FaseDiurna(){
        super();
    }

    public FaseDiurna(FaseDiurnaData info) {
        super();
    }

    public void ejecutar(Accion comando) {
        comando.execute();
    }

    public FaseDiurnaData exportarInfo(){
        return new FaseDiurnaData(votacion.obtenerMasVotado());
    }

    @Override
    public void registrarVoto(Jugador votante, Jugador objetivo) {
        this.votacion.registrarVoto(objetivo);
    }
}
