package edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores;
import edu.fiuba.algo3.vistas.Notificable;
import java.util.List;

public class GanaLaMafia extends Ganador {
    private final List<Notificable> notificables;

    public GanaLaMafia(List<Notificable> notificables) {
        this.notificables = notificables;
    }

    @Override
    public void anunciar() {
        for(Notificable notificable: notificables){
            notificable.actualizar(this);
        }
    }
}
