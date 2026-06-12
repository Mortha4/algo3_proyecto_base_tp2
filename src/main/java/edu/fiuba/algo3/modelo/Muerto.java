package edu.fiuba.algo3.modelo;

public class Muerto implements Estado {
    @Override
    public boolean estaVivo() {
        return false;
    }
}
