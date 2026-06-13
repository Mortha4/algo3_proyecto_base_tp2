package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.Rol;

public class Jugador {
    private final Rol rol;
    private final String nombre;
    private Estado estado;

    public Jugador(Rol rol, String nombre) {
        this.rol = rol;
        this.nombre = nombre;
        this.estado = new Vivo();
    }

    public Rol verRol(Jugador otroJugador){
        if(otroJugador.equals(this)){
            return rol;
        }

        throw new NoVisibleException();
    }

    public void morir() {
        this.estado = new Muerto();
    }

    public void votar(Jugador objetivo){
        this.estado.votar(objetivo);
    }

    public boolean estaVivo() {
        return this.estado.estaVivo();
    }
}
