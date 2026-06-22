package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.roles.Rol;

public class Muerto implements Estado {

    @Override
    public Candidato crearCandidato(Jugador otroJugador){
        throw new SeleccionInvalidaException();
    }

    @Override
    public Candidato devolverCandidato(Jugador otroJugador) {
        throw new SeleccionInvalidaException();
    }

    @Override
    public void accionNocturna(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol) {
        throw new SeleccionInvalidaException();
    }

    @Override
    public void accionDiurna(FaseDiurna faseDiurna, Jugador ejecuror, Jugador objetivo, Rol rol) {
        throw new SeleccionInvalidaException();
    }

    @Override
    public boolean estaVivo(){ return false; }
}
