package edu.fiuba.algo3.modelo.acciones;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Revelar implements Accion{
    private final Jugador revelado;
    private final FaseDiurna fase;
    private final Jugador revelador;

    public Revelar(FaseDiurna fase, Jugador revelador, Jugador revelado){
        this.fase = fase;
        this.revelador = revelador;
        this.revelado = revelado;
    }

    @Override
    public void execute() {
        fase.revelar(revelador, revelado);
    }
}
