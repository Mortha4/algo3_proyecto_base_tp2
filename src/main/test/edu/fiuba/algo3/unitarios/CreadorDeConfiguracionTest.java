package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepartoDeCartasTest {

    // FIXME: remove and make MazoTest instead

    @Test
    public void Test01EnUnaPatidaCon5JugadoresTodosRecibenUnRol(){
        //arrange
        List<String> nombresDeJugadores = new ArrayList<>();
        nombresDeJugadores.addAll(List.of("jugador1", "jugador2", "jugador3", "jugador4", "jugador5"));

        Partida partida = new Partida(nombresDeJugadores);

        //act
        partida.repartirCartas();
        List<Jugador> jugadores = partida.getJugadores();

        //assert
        for (Jugador jugador : jugadores) {
            assertNotNull(jugador.verRol(jugador), "Algun jugador no tiene rol");
        }
    }
    @Test
    public void Test02EnUnaPatidaCon7JugadoresTodosRecibenUnRol(){
        //arrange
        List<String> nombresDeJugadores = new ArrayList<>();
        nombresDeJugadores.addAll(List.of("1", "2", "3", "4", "5", "6", "7"));

        Partida partida = new Partida(nombresDeJugadores);

        //act
        partida.repartirCartas();
        List<Jugador> jugadores = partida.getJugadores();

        //assert
        for (Jugador jugador : jugadores) {
            assertNotNull(jugador.verRol(jugador), "Algun jugador no tiene rol");
        }
    }
    @Test
    public void Test03EnUnaPatidaCon10JugadoresTodosRecibenUnRol(){
        //arrange
        List<String> nombresDeJugadores = new ArrayList<>();
        nombresDeJugadores.addAll(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

        Partida partida = new Partida(nombresDeJugadores);

        //act
        partida.repartirCartas();
        List<Jugador> jugadores = partida.getJugadores();

        //assert
        for (Jugador jugador : jugadores) {
            assertNotNull(jugador.verRol(jugador), "Algun jugador no tiene rol");
        }
    }









}
