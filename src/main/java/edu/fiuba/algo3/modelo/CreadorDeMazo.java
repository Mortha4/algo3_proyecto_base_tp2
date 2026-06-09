package edu.fiuba.algo3.modelo;

import java.util.*;


public class CreadorDeMazo {
    private List<ConfiguracionDeMazo> configuraciones;


    //constructor

    public CreadorDeMazo(){
        this.configuraciones = List.of(new ConfiguracionPequenia(),new ConfiguracionMediana(),new ConfiguracionGrande());

    }


    //metodo
    public List<Rol> crearMazo(int cantidadJugadores) {
        List<Rol> mazo = new ArrayList<>();
        ConfiguracionDeMazo configMazo = this.configuraciones.stream().filter(c -> c.aplicaPara(cantidadJugadores)).findFirst().orElseThrow(() -> new IllegalArgumentException("No existe una configuración"));
        int cantidadMafiosos = configMazo.obtenerCantidadMafiosos(), cantidadCiudadanos;

        configMazo.agregarRolesEspeciales(mazo);

        for(int i=0 ; i < cantidadMafiosos; i ++){
            mazo.add(new Mafioso());
        }

        cantidadCiudadanos = cantidadJugadores - mazo.size();
        for(int i=0 ; i < cantidadCiudadanos ; i++){
            mazo.add(new Ciudadano());
        }

        return mazo;

    }





}
