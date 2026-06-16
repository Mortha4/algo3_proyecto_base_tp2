package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private Jugador ciudadano1;
    private Jugador ciudadano2;

    @BeforeEach
    public void arrange(){
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
    }

    @Test
    public void test01JugadorNoPuedeVerElRolDeOtroJugador(){
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano1.verRol(ciudadano2), "Un jugador puede ver el rol de otro");
    }
    @Test
    public void test02JugadorPuedeVerSuRol(){
        // Arrange
        Medico medico = new Medico();
        Jugador jugador = new Jugador(medico, "medico");

        // Act y Assert
        assertEquals(medico, jugador.verRol(jugador));
    }
    @Test
    public void test03UnJugadorSeCreaVivo(){
        // Act y Assert
        assertTrue(ciudadano1.estaVivo(),
                "El jugador se creo muerto.");
    }
    @Test
    public void test04AlMatarUnJugadorNoEstaVivo(){
        // Act
        ciudadano1.morir();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "El jugador sigue vivo luego de morir()");
    }

    @Test
    public void test05UnJugadorMuertoNoPuedeRealizarAcciones(){
        // Arrange
        ciudadano1.morir();
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano1.accionDiurna(new FaseDiurna(), ciudadano2),
                "Un jugador pudo votar muerto");
    }

}
