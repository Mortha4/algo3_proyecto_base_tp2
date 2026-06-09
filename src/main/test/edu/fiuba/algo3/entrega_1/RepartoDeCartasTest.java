package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepartoDeCartasTest {


    @Test
    public void Test01EnUnaPatidaCon5JugadoresTodosRecibenUnRol(){
        //arrange
        List<Jugador> jugadores = List.of(new Jugador(),new Jugador(),new Jugador(),new Jugador(),new Jugador() );
        Partida partida = new Partida(jugadores);

        //act
        partida.iniciar();



        //assert
        for (Jugador jugador : jugadores) {
            assertTrue(jugador.tieneRolAsignado(), "Un jugador o varios no tienen rol");
        }


    }









}
