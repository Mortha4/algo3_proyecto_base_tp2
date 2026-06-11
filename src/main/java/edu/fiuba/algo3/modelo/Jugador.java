package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoVisible;
import edu.fiuba.algo3.modelo.roles.Rol;
import edu.fiuba.algo3.modelo.roles.RolVisitable;

public class Jugador {
    private Rol rol;
    private boolean vivo = true;

    public Jugador() {}

    public Jugador(Rol rol) {
        this.asignarRol(rol);
    }

    public void asignarRol (Rol rol){
        this.rol = rol;
    }

    public boolean tieneRolAsignado() {
        return this.rol != null;
    }

    public Rol verRol(Jugador otroJugador){
        if(otroJugador.equals(this)){
            return rol;
        }
        throw new NoVisible();
    }

    public void eliminar() {
        this.vivo = false;
    }

    public boolean estaVivo() {
        return this.vivo;
    }
}
