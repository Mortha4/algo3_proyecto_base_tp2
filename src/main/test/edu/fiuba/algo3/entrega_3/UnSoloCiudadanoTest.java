package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.UnSoloCiudadano;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GananLosCiudadanos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.excepciones.SinJugadoresException;
import edu.fiuba.algo3.modelo.excepciones.TodosEstanMuertosException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Medico;
import edu.fiuba.algo3.unitarios.partida.NotificableMock;
import edu.fiuba.algo3.vistas.Notificable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnSoloCiudadanoTest {
    private List<Jugador> jugadores;
    private List<Notificable> notificables;
    private NotificableMock unNotificable;
    private Jugador ciudadano;
    private UnSoloCiudadano condicion;

    @BeforeEach
    public void arrange(){
        unNotificable  = new NotificableMock();
        notificables = new ArrayList<>(List.of(unNotificable));
        jugadores = new ArrayList<>();
        ciudadano = new Jugador(new Ciudadano(), "ciudadano");
    }

    @Test
    public void test01ConUnCiudadanoGananLosCiudadanos(){
        // Arrange
        jugadores.add(ciudadano);
        condicion = new UnSoloCiudadano(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoCiudadanos(),
                "Si el unico jugador es un ciudadano deberia devolver GananLosCiudadanos");
    }

    @Test
    public void test02ConDosCiudadanosNoHayGanador(){
        // Arrange
        Jugador segundoCiudadano = new Jugador(new Ciudadano(), "ciudadano2");
        jugadores.add(ciudadano);
        jugadores.add(segundoCiudadano);
        condicion = new UnSoloCiudadano(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Con mas de un ciudadano deberia devolver un NoHayGanador");
    }

    @Test
    public void test03ConUnCiudadanoYOtroRolNoHayGanador(){
        // Arrange
        Jugador segundoCiudadano = new Jugador(new Medico(), "ciudadano2");
        jugadores.add(segundoCiudadano);
        jugadores.add(ciudadano);
        condicion = new UnSoloCiudadano(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Con mas de un ciudadano deberia devolver un NoHayGanador");
    }

    @Test
    public void test04ConJugadoresMuertosLanzaExcepcion(){
        // Arrange
        ciudadano.morir();
        jugadores.add(ciudadano);

        // Act y Assert
        assertThrows(TodosEstanMuertosException.class,
                () -> new UnSoloCiudadano(jugadores),
                "Recibiendo una lista de jugadores muertos deberia lanzar execepcion");
    }

    @Test
    public void test05ConMafiososVivosNoHayGanador(){
        // Arrange
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        jugadores.add(ciudadano);
        jugadores.add(mafioso);
        condicion = new UnSoloCiudadano(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Con ciudadanos vivos deberia devolver un NoHayGanador");
    }

    @Test
    public void test06SinJugadoresLanzaExcepcion(){
        assertThrows(SinJugadoresException.class,
                () -> new UnSoloCiudadano(jugadores),
                "Chequear la coleccion sin jugadores deberia lanzar una excepcion.");
    }

    @Test
    public void test07SinCiudadanosNoHayGanador(){
        // Arrange
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        jugadores.add(mafioso);
        condicion = new UnSoloCiudadano(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Sin ciudadanos deberia deberia devolver NoHayGanador");
    }

    @Test
    public void test08ConUnCiudadanoDeOtroRolGananLosCiudadanos(){
        // Arrange
        Jugador medico = new Jugador(new Medico(), "ciudadano2");
        jugadores.add(medico);
        condicion = new UnSoloCiudadano(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoCiudadanos(),
                "Con un ciudadano de distinto rol deberian ganar los ciudadanos");
    }
}
