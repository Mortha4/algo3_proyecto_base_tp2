package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.excepciones.NoSePuedeAutonominarException;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Nominar implements Accion{
    private final Fase fase;
    private final Jugador nominado;
    private final Jugador nominador;

    public Nominar(Fase fase, Jugador nominador, Jugador nominado){
        if(nominador.equals(nominado)){
            throw new NoSePuedeAutonominarException();
        }
        this.fase = fase;
        this.nominado = nominado;
        this.nominador = nominador;
    }

    @Override
    public void execute() {
        fase.nominar(nominador, nominado);
    }
}
