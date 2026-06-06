package edu.fiuba.algo3.modelo;

public class Jugador {
    Rol rol;

    public void asignarRol (Rol rol){
        this.rol = rol;
    }

    public boolean tieneRolAsignado() {
        return this.rol != null;
    }



}
