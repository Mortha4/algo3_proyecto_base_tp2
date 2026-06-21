package edu.fiuba.algo3.unitarios.fase;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.VotarAlMismoJugadorException;
import edu.fiuba.algo3.modelo.excepciones.VotarMismoRolException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaseDiurnaTest {
    @Test
    public void test01UnJugadorNoPuedeVotarseASiMismo(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        FaseDiurna fase = new FaseDiurna();

        // Act y Assert
        assertThrows(VotarAlMismoJugadorException.class,
                () -> ciudadano1.votar(fase, ciudadano1),
                "Un jugador no debería poder votarse a sí mismo");
    }
}
