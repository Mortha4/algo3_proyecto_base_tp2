package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreadorDeConfiguracionTest {
    @Test
    public void test01TodosLosJugadoresRecibenUnRolEnUnaPartidaDe5Jugadores(){
        // Arrange
        List<String> nombresDeJugadores = new ArrayList<>(List.of("jugador1", "jugador2", "jugador3", "jugador4", "jugador5"));

        Partida partida = new Partida(nombresDeJugadores);

        // Act
        partida.repartirCartas();
        List<Jugador> jugadores = partida.getJugadores();

        // Assert
        for (Jugador jugador : jugadores) {
            assertNotNull(jugador.verRol(jugador),
                    "Todos los jugadores deberían recibir un rol al repartir las cartas");
        }
    }

    @Test
    public void test02TodosLosJugadoresRecibenUnRolEnUnaPartidaDe7Jugadores(){
        // Arrange
        List<String> nombresDeJugadores = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7"));

        Partida partida = new Partida(nombresDeJugadores);

        // Act
        partida.repartirCartas();
        List<Jugador> jugadores = partida.getJugadores();

        // Assert
        for (Jugador jugador : jugadores) {
            assertNotNull(jugador.verRol(jugador),
                    "Todos los jugadores deberían recibir un rol al repartir las cartas");
        }
    }

    @Test
    public void test03TodosLosJugadoresRecibenUnRolEnUnaPartidaDe10Jugadores(){
        // Arrange
        List<String> nombresDeJugadores = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

        Partida partida = new Partida(nombresDeJugadores);

        // Act
        partida.repartirCartas();
        List<Jugador> jugadores = partida.getJugadores();

        // Assert
        for (Jugador jugador : jugadores) {
            assertNotNull(jugador.verRol(jugador),
                    "Todos los jugadores deberían recibir un rol al repartir las cartas");
        }
    }
}
