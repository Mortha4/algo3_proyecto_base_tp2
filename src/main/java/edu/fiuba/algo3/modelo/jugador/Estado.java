package edu.fiuba.algo3.modelo.jugador;

public interface Estado {
    boolean estaVivo();
    void votar(Jugador objetivo);
}
