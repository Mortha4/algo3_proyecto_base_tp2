package edu.fiuba.algo3.unitarios;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaseDiurnaTest {
    private Jugador muerto;
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private Jugador ciudadano3;
    private FaseDiurna fase;

    @BeforeEach
    public void arrange(){
        // Arrange
         ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
         ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
         ciudadano3 = new Jugador(new Ciudadano(), "ciudadano3");
         fase = new FaseDiurna();
    }


    @Test
    public void test03UnJugadorNoPuedeVotarseASiMismo(){
        // Act y Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano1.accionDiurna(fase, ciudadano1),
                "Un jugador se voto a si mismo");
    }
}
