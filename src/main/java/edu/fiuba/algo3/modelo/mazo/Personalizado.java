package edu.fiuba.algo3.modelo.mazo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;
import edu.fiuba.algo3.modelo.roles.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class Personalizado extends CreadorDeMazo {
    private static final int CIUDADANOS_POR_MAFIOSO = 3;
    private final Set<Supplier<Rol>> configuracionDeseada;
    private final List<Rol> roles = new ArrayList<>();
    private final int cantidadDeRoles;

    public Personalizado(Set<Supplier<Rol>> config, int cantidadDeJugadores) {
        if(config.size() > cantidadDeJugadores ||
        cantidadDeJugadores < 5 ||
        cantidadDeJugadores > 12){
            throw new CantidadDeJugadoresException();
        }
        this.configuracionDeseada = config;
        this.cantidadDeRoles = cantidadDeJugadores;
    }

    @Override
    public List<Rol> obtenerRoles() {
        agregarRolesEspeciales();
        agregarMafiosos(cantidadDeRoles/CIUDADANOS_POR_MAFIOSO);
        rellenarConCiudadanos(roles);
        return roles;
    }

    private void agregarRolesEspeciales(){
        for (Supplier<Rol> creador : configuracionDeseada) {
            roles.add(creador.get());
        }
    }

    private void agregarMafiosos(int cantidadDeMafiosos){
        for(int i = 0; i < cantidadDeMafiosos; i++){
            roles.add(new Mafioso());
        }
    }
}