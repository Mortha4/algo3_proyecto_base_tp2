package edu.fiuba.algo3.unitarios.partida;

import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PartidaTest {
    private List<Jugador> mafiosos;
    private List<Jugador> ciudadanos;
    private Jugador unCiudadano;
    private Jugador unMafioso;
    private Jugador detective = null;
    private Jugador medico = null;
    private Jugador padrino;
    private Jugador sheriff;
    private Partida partida;
    private Fase faseActual;

    public void arrangeDe5Jugadores(){
        partida = new Partida(List.of("1", "2", "3", "4", "5"));
        partida.iniciar();
        faseActual = partida.getFaseActual();
        ciudadanos = new ArrayList<>();
        mafiosos = new ArrayList<>();
        for(Jugador jugador: partida.getJugadores()){
            Rol rol = jugador.getRol();
            if(rol instanceof Mafioso) {
                mafiosos.add(jugador);
            } else if (rol instanceof Ciudadano){
                ciudadanos.add(jugador);
            } else if (rol instanceof Detective){
                detective = jugador;
            } else if (rol instanceof Medico){
                medico = jugador;
            }
        }
        unCiudadano = ciudadanos.get(0);
        unMafioso = mafiosos.get(0);
    }

    @Test
    public void test01TodosLosJugadoresRecibenUnRolEnUnaPartidaDe5Jugadores(){
        // Arrange
        List<String> nombresDeJugadores = new ArrayList<>(List.of("jugador1", "jugador2", "jugador3", "jugador4", "jugador5"));

        Partida partida = new Partida(nombresDeJugadores);

        // Act
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
        List<Jugador> jugadores = partida.getJugadores();

        // Assert
        for (Jugador jugador : jugadores) {
            assertNotNull(jugador.verRol(jugador),
                    "Todos los jugadores deberían recibir un rol al repartir las cartas");
        }
    }

    @Test
    public void test04TranscurreLaPrimerNocheCorrectamente(){
        // Act
        arrangeDe5Jugadores();
        unMafioso.nominar(faseActual, unCiudadano);
        for(Jugador mafia: mafiosos){
            mafia.votar(faseActual, unCiudadano);
        }
        partida.cambiarFase();
        assertFalse(unCiudadano.estaVivo(),
                "Si todos votaron a un jugador, al cambiar de fase deberia morir.");
    }
}
