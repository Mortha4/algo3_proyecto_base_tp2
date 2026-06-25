package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.excepciones.NoSePuedeAutonominarException;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Nominar implements Accion{
    private final Fase fase;
    private final Jugador nominado;
    private final Jugador nominante;

    public Nominar(Fase fase, Jugador nominante, Jugador nominado){
        if(nominante.equals(nominado)){
            throw new NoSePuedeAutonominarException();
        }
        this.fase = fase;
        this.nominado = nominado;
        this.nominante = nominante;
    }

    @Override
    public void execute() {
        fase.nominar(nominante, nominado);
    }
}
