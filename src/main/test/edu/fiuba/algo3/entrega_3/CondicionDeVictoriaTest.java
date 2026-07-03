package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.excepciones.SinJugadoresException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
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
}
