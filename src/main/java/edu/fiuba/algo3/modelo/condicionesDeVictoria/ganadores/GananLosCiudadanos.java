package edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores;

import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public class GananLosCiudadanos extends Ganador {
    public GananLosCiudadanos(List<Notificable> notificables) {
        this.notificables = notificables;
    }


    @Override
    protected void actualizarNotificable(Notificable notificable) {
        notificable.actualizar(this);
    }
}
