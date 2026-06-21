package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.excepciones.JugadorMuertoException;
import edu.fiuba.algo3.modelo.excepciones.JugadorMuertoNoPuedeVotarException;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoMuertoException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.roles.Rol;

public class Muerto implements Estado {

    @Override
    public Candidato crearCandidato(Jugador otroJugador){
        throw new JugadorMuertoException();
    }

    @Override
    public Candidato devolverCandidato(Jugador otroJugador) {

        throw new ObjetivoMuertoException();
    }

    @Override
    public void accionNocturna(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol) {
        throw new JugadorMuertoException();
    }

    @Override
    public void accionDiurna(FaseDiurna faseDiurna, Jugador ejecutor, Jugador objetivo, Rol rol) {
        throw new JugadorMuertoException();
    }

    @Override
    public void votar(FaseDiurna fase, Jugador votante, Jugador votado, Rol rol) {
        throw new JugadorMuertoNoPuedeVotarException();
    }

    @Override
    public boolean estaVivo(){ return false; }
}
