package edu.fiuba.algo3.modelo.jugador;

public class Muerto implements Estado {
    @Override
    public boolean estaVivo() {
        return false;
    }
}
