package edu.fiuba.algo3.unitarios.fase;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoMuertoException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeVotarASiMismoException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.SinMuerte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaseDiurnaTest {
    private Jugador ciudadano1;
    private Jugador sheriff;
    private FaseDiurna fase;

    @BeforeEach
    public void arrange(){
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        sheriff = new Jugador(new Sheriff(), "sheriff");
        fase = new FaseDiurna(new SinMuerte());
    }

    @Test
    public void test01UnJugadorNoPuedeVotarseASiMismo(){
        // Act y Assert
        assertThrows(NoSePuedeVotarASiMismoException.class,
                () -> ciudadano1.votar(fase, ciudadano1),
                "Un jugador no debería poder votarse a sí mismo");
    }

    @Test
    public void test02UnJugadorPuedeElegirNoActuar(){
        // Act y Assert
        assertDoesNotThrow( () -> ciudadano1.noActuar(fase),
                "Cuando un jugador elige no actuar, no debería lanzar excepción");
    }

    @Test
    public void test03UnSheriffPuedeRevelarOtroJugador(){
        // Act y Assert
        assertDoesNotThrow( () -> sheriff.accion(fase, ciudadano1),
                "Un sheriff debería poder revelar un jugador");
    }

    @Test
    public void test04UnSheriffDeberiaPoderRevelarseASiMismo(){
        // Act y Assert
        assertDoesNotThrow( () -> sheriff.accion(fase, sheriff),
                "Un sheriff debería poder revelar su propio bando.");
    }

    @Test
    public void test05UnSheriffNoDeberiaPoderRevelarAUnMuerto(){
        // Act
        ciudadano1.morir();
        // Assert
        assertThrows(ObjetivoMuertoException.class, () -> sheriff.accion(fase, ciudadano1),
                "Un sheriff al intentar revelar a un muerto, debería lanzar excepción");
    }

    @Test
    public void test06UnSheriffMuertoNoPuedeRevelarAOtro(){
        // Act
        sheriff.morir();

        // Assert
        assertThrows(ObjetivoMuertoException.class, () -> sheriff.accion(fase, ciudadano1),
                "Un sheriff muerto al intentar revelar, debería lanzar excepción.");
    }
}
