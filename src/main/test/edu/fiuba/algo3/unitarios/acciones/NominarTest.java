package edu.fiuba.algo3.unitarios.acciones;
import edu.fiuba.algo3.modelo.excepciones.JugadorMuertoNoPuedeNominarException;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoMuertoException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.SinMuerte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class NominarTest {
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private FaseDiurna fase;

    @BeforeEach
    public void arrange(){
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        ciudadano2 = new Jugador(new Ciudadano(), "lucas");
        fase = new FaseDiurna(new SinMuerte());
    }

    @Test
    public void test01unJugadorMuertoNoPuedeNominar(){
        // Arrange
        ciudadano1.morir();

        // Act y Assert
        assertThrows(JugadorMuertoNoPuedeNominarException.class,
                () -> ciudadano1.nominar(fase, ciudadano2),
                "Un jugador muerto no deberia poder nominar a otro.");
    }

    @Test
    public void test02NoSePuedeNominarUnJugadorMuerto(){
        // Arrange
        ciudadano2.morir();

        // Act y Assert
        assertThrows(ObjetivoMuertoException.class,
                () -> ciudadano1.nominar(fase, ciudadano2),
                "Un jugador no deberia poder nominar a uno muerto.");
    }

}
