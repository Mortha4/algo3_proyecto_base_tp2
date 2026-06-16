package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.excepciones.LosMuertosNoVotanException;

public class Muerto implements Estado {
    @Override
    public boolean estaVivo() {
        return false;
    }

    @Override
    public void votar(Jugador objetivo){
        throw new LosMuertosNoVotanException();
    }
}
