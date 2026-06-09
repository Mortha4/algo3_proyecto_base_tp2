package edu.fiuba.algo3.modelo;

import java.util.List;
import edu.fiuba.algo3.modelo.roles.*;

public interface ConfiguracionDeMazo {

    boolean aplicaPara(int cantidadJugadores);
    void agregarRolesEspeciales(List<Rol> mazo);
    int obtenerCantidadMafiosos();
}
