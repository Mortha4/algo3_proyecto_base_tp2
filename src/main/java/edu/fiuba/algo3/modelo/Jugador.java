package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.roles.Rol;

public class Jugador {
    private Rol rol;

    public void asignarRol (Rol rol){
        this.rol = rol;
    }

    public boolean tieneRolAsignado() {
        return this.rol != null;
    }



}
