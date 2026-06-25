package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.acciones.Nada;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.excepciones.JugadorMuertoException;
import edu.fiuba.algo3.modelo.excepciones.JugadorMuertoNoPuedeNominarException;
import edu.fiuba.algo3.modelo.excepciones.JugadorMuertoNoPuedeVotarException;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoMuertoException;
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
    public void accion(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol) {
        throw new JugadorMuertoException();
    }

    @Override
    public void accion(FaseDiurna faseDiurna, Jugador ejecutor, Jugador objetivo, Rol rol) {
        throw new JugadorMuertoException();
    }

    @Override
    public void votar(Fase fase, Jugador votante, Jugador votado, Rol rol) {
        throw new JugadorMuertoNoPuedeVotarException();
    }

    @Override
    public void contar(CondicionDeVictoria condicion, Rol rol) {}

    @Override
    public void noActuar(Fase fase, Jugador jugador) {
        fase.ejecutar(new Nada());
    }

    @Override
    public void nominar(Fase fase, Jugador jugador, Jugador nominado) {
        throw new JugadorMuertoNoPuedeNominarException();
    }

    @Override
    public boolean estaVivo(){ return false; }
}
