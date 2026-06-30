package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.excepciones.SinJugadoresException;
import edu.fiuba.algo3.modelo.excepciones.TodosEstanMuertosException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class CondicionDeVictoriaTest {
    List<Jugador> jugadores;
    CondicionDeVictoria condicion;


    @Test
    public void test01CondicionDeVictoriaLanzaExcepcionConColeccionVacia(){
        // Arrange
        jugadores = new ArrayList<>();

        // Act y Assert
        assertThrows(SinJugadoresException.class,
                () -> condicion = new CondicionDeVictoriaDummy(jugadores),
                "Sin jugadores deberia lanzar una excepcion.");
    }

    @Test
    public void test02CondicionDeVictoriaLanzaExcepcionConJugadoresMuertos(){
        // Arrange
        Jugador ciudadanoMuerto = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafiosoMuerto = new Jugador(new Mafioso(), "mafioso");
        jugadores = new ArrayList<>();

        // Act
        mafiosoMuerto.morir();
        ciudadanoMuerto.morir();
        jugadores.addAll(List.of(ciudadanoMuerto, mafiosoMuerto));

        // Assert
        assertThrows(TodosEstanMuertosException.class,
                () -> new CondicionDeVictoriaDummy(jugadores),
                "Con todos los jugadores muertos deberia lanzarse una excepcion. ");

    }

}
