package edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores;

import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public class GananLosCiudadanos extends Ganador {
    private final List<Notificable> notificables;

    public GananLosCiudadanos(List<Notificable> notificables) {
        this.notificables = notificables;
    }

    @Override
    public void anunciar() {
        for(Notificable notificable: notificables){
            notificable.actualizar(this);
        }
    }
}
