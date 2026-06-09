package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoVisible;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Medico;
import edu.fiuba.algo3.modelo.roles.Rol;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void test01JugadorNoPuedeVerElRolDeOtroJugador(){
        // Arrange
        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();

        // Act y Assert
        assertThrows(NoVisible.class, () -> jugador.verRol(otroJugador), "Un jugador puede ver el rol de otro");
    }
    @Test
    public void test02JugadorPuedeVerSuRol(){
        // Arrange
        Jugador jugador = new Jugador();
        Medico medico = new Medico();
        jugador.asignarRol(medico);

        // Act

        Rol result = jugador.verRol(jugador);

        // Assert
        assertEquals(medico, result, "Un jugador no puede ver su propio rol");
    }
}
