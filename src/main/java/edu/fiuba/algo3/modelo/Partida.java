package edu.fiuba.algo3.modelo;

import java.util.List;

public class Partida {
    private List<Jugador> jugadores;
    private CreadorDeMazo creador;

    public Partida(List<Jugador> jugadores)
    {
        this.jugadores = jugadores;
        creador = new CreadorDeMazo();
    }

    public void iniciar(){
        int cantidadJugadores = jugadores.size();
        List<Rol> mazo ;
        mazo = creador.crearMazo(cantidadJugadores);

        //asignar roles a todos los jugadores

        for(int i=0 ; i < cantidadJugadores ;i++){
            jugadores.get(i).asignarRol(mazo.get(i));
        }

    }



}
