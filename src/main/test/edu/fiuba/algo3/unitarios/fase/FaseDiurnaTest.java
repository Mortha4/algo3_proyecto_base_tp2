package edu.fiuba.algo3.unitarios.fase;
import edu.fiuba.algo3.modelo.excepciones.VotarAlMismoJugadorException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaseDiurnaTest {
    private Jugador ciudadano1;
    private FaseDiurna fase;

    @BeforeEach
    public void arrange(){
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        fase = new FaseDiurna();
    }

    @Test
    public void test01UnJugadorNoPuedeVotarseASiMismo(){
        // Act y Assert
        assertThrows(VotarAlMismoJugadorException.class,
                () -> ciudadano1.votar(fase, ciudadano1),
                "Un jugador no debería poder votarse a sí mismo");
    }

    @Test
    public void test02UnJugadorPuedeElegirNoActuar(){
        // Act y Assert
        assertDoesNotThrow( () -> ciudadano1.noActuar(fase),
                "Cuando un jugador elige no actuar, no deberia lanzar excepcion");
    }
}
