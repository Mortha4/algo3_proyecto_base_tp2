package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.NoHayMafiosos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GananLosCiudadanos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
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

public class NoHayMafiososTest {
    private List<Notificable> notificables;
    private NotificableMock unNotificable;
    private Jugador mafioso;
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private NoHayMafiosos condicion;
    private List<Jugador> jugadores;

    @BeforeEach
    public void arrange(){
        jugadores = new ArrayList<>();
        unNotificable  = new NotificableMock();
        notificables = new ArrayList<>(List.of(unNotificable));
        mafioso = new Jugador(new Mafioso(), "mafioso");
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano");
    }

    @Test
    public void test01SinMafiososGananLosCiudadanos(){
        // Arrange
        jugadores.add(ciudadano1);
        condicion = new NoHayMafiosos(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoCiudadanos(),
                "Sin Mafiosos deberia devolver un GananLosCiudadanos");
    }

    @Test
    public void test02ConUnMafiosoNoHayGanador(){
        // Arrange
        jugadores.add(mafioso);
        condicion = new NoHayMafiosos(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Con un mafioso deveria devolver un NoHayGanador");
    }

    @Test
    public void test03ConMafiososYCiudadanosNoHayGanador(){
        // Arrange
        jugadores.add(mafioso);
        jugadores.add(ciudadano1);
        condicion = new NoHayMafiosos(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoNoHayGanador(),
                "Con mafiosos y ciudadanos deveria devolver un NoHayGanador");
    }

    @Test
    public void test04ConMasDeUnCiudadanoGananLosCiudadanos(){
        // Arrange
        jugadores.add(ciudadano1);
        jugadores.add(ciudadano2);
        condicion = new NoHayMafiosos(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoCiudadanos(),
                "Con mafiosos y ciudadanos deveria devolver un NoHayGanador");
    }

    @Test
    public void test05ConUnMafiosoMuertoGananLosCiudadanos(){
        // Arrange
        mafioso.morir();
        jugadores.add(mafioso);
        jugadores.add(ciudadano1);
        condicion = new NoHayMafiosos(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoCiudadanos(),
                "Con mafiosos y ciudadanos deveria devolver un NoHayGanador");
    }

    @Test
    public void test06ConUnPadrinoMuertoGananLosCiudadanos(){
        // Arrange
        Jugador padrino = new Jugador(new Padrino(), "padrino");
        padrino.morir();
        jugadores.add(padrino);
        jugadores.add(ciudadano1);
        condicion = new NoHayMafiosos(jugadores);
        // Act
        condicion.chequear(notificables);
        // Assert
        assertEquals(1,
                unNotificable.getVecesInvocadoCiudadanos(),
                "Con mafiosos y ciudadanos deveria devolver un NoHayGanador");
    }
}
