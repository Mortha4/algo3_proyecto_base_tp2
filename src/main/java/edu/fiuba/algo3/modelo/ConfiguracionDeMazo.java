package edu.fiuba.algo3.modelo;

import java.util.List;

public interface ConfiguracionDeMazo {

    boolean aplicaPara(int cantidadJugadores);
    void agregarRolesEspeciales(List<Rol> mazo);
    int obtenerCantidadMafiosos();
}
