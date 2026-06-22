package edu.fiuba.algo3.unitarios.jugador;

import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
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
    public void test01UnJugadorSeCreaVivo(){
        // Act y Assert
        assertTrue(ciudadano1.estaVivo(),
                "Un jugador recién creado debería estar vivo");
    }

    @Test
    public void test02AlMatarUnJugadorNoEstaVivo(){
        // Act
        ciudadano1.morir();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "Un jugador no debería estar vivo después de morir");
    }

    @Test
    public void test03UnJugadorMuertoNoPuedeRealizarAcciones(){
        // Arrange
        ciudadano1.morir();

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano1.accionDiurna(new FaseDiurna(), ciudadano2),
                "Un jugador muerto no debería poder realizar acciones");
    }

}
