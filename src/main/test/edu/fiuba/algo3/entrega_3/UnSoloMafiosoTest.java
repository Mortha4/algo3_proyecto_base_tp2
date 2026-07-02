package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.UnSoloMafioso;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GanaLaMafia;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.excepciones.SinJugadoresException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Padrino;
import edu.fiuba.algo3.unitarios.partida.NotificableMock;
import edu.fiuba.algo3.vistas.Notificable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class UnSoloMafiosoTest {
    private List<Jugador> jugadores;
    private List<Notificable> notificables;
    private NotificableMock unNotificable;
    private Jugador mafioso;
    private Jugador padrino;
    private UnSoloMafioso condicion;

    @BeforeEach
    public void arrange(){
        jugadores = new ArrayList<>();
        unNotificable  = new NotificableMock();
        notificables = new ArrayList<>(List.of(unNotificable));
        mafioso = new Jugador(new Mafioso(), "mafioso");
        padrino = new Jugador(new Padrino(), "mafioso");
    }

    @Test
    public void test01ConUnMafiosoGanaLaMafia(){
        // Arrange
        jugadores.add(mafioso);
        condicion = new UnSoloMafioso(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoMafia(),
                "Si el unico jugador es un mafioso deberia devolver GanaLaMafia");
    }

    @Test
    public void test02ConUnPadrinoGanaLaMafia(){
        // Arrange
        jugadores.add(padrino);
        condicion = new UnSoloMafioso(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoMafia(),
                "Si el unico jugador es un mafioso deberia devolver GanaLaMafia");
    }

    @Test
    public void test03ConDosMafiososNoHayGanador(){
        // Arrange
        Jugador segundoMafioso = new Jugador(new Mafioso(), "mafioso2");
        jugadores.add(mafioso);
        jugadores.add(segundoMafioso);
        condicion = new UnSoloMafioso(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Si hay dos mafiosos, no deberia decir que gano la mafia");
    }

    @Test
    public void test04ConUnMafiosoYUnPadrinoNoHayGanador(){
        // Arrange
        jugadores.add(mafioso);
        jugadores.add(padrino);
        condicion = new UnSoloMafioso(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Con mas de un mafioso deberia devolver un NoHayGanador");
    }

    @Test
    public void test06ConCiudadanosVivosNoHayGanador(){
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        jugadores.add(ciudadano);
        jugadores.add(mafioso);
        condicion = new UnSoloMafioso(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Con ciudadanos vivos deberia devolver un NoHayGanador");
    }

    @Test
    public void test07SinJugadoresLanzaExcepcion(){
        assertThrows(SinJugadoresException.class,
                () -> new UnSoloMafioso(jugadores),
                "Chequear la coleccion sin jugadores deberia lanzar una excepcion.");
    }

    @Test
    public void test08SinMafiososNoHayGanador(){
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        jugadores.add(ciudadano);
        condicion = new UnSoloMafioso(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Sin mafiosos deberia deberia devolver NoHayGanador");

    }
}
