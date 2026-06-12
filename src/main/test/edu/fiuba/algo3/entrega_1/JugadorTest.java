package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void test01JugadorNoPuedeVerElRolDeOtroJugador(){
        // Arrange
        Jugador jugador = new Jugador(new Ciudadano(), "jugador1");
        Jugador otroJugador = new Jugador(new Ciudadano(), "jugador2");

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> jugador.verRol(otroJugador), "Un jugador puede ver el rol de otro");
    }
    @Test
    public void test02JugadorPuedeVerSuRol(){
        // Arrange
        Medico medico = new Medico();
        Jugador jugador = new Jugador(medico, "medico");

        // Act y Assert
        assertEquals(medico, jugador.verRol(jugador));
    }
}
