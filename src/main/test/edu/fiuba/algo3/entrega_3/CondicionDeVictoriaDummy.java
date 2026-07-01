package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public class CondicionDeVictoriaDummy extends CondicionDeVictoria {
    public CondicionDeVictoriaDummy(List<Jugador> jugadores) {
        super(jugadores);
    }

    @Override
    protected void chequearCondicion(List<Notificable> notificables) {}
}
