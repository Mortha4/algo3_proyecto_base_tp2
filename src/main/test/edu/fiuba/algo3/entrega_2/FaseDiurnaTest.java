package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
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
    public void test01VotacionSinEmpateSoloUsaJugadoresVivos(){
        // Act y assert
        ciudadano1.morir();
        assertThrows(SeleccionInvalidaException.class, () -> ciudadano2.accionDiurna(fase, ciudadano1),
                "Se pudo votar a un muerto");

    }

    @Test
    public void test02EnEmpateNoMuereNadie(){
        // Act
        ciudadano1.accionDiurna(fase, ciudadano2);
        ciudadano2.accionDiurna(fase, ciudadano1);
        // Assert
        assertThrows(NoHuboDecisionException.class,
                () -> fase.finalizar(),
                "Se elimino a alguien al empatar");
    }

    @Test
    public void test03UnJugadorNoPuedeVotarseASiMismo(){
        // Act y Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano1.accionDiurna(fase, ciudadano1),
                "Un jugador se voto a si mismo");
    }

    @Test
    public void test04VotacionValidaFinalizaCorrectamente(){
        // Act
        ciudadano1.accionDiurna(fase, ciudadano3);
        ciudadano2.accionDiurna(fase, ciudadano3);
        ciudadano3.accionDiurna(fase, ciudadano2);
        fase.finalizar();
        // Assert
        assertFalse(ciudadano3.estaVivo(), "En una votacion valida, no se elimino el jugador mas votado");
    }

    @Test
    public void test05JugadorMuertoNoPuedeSeguirVotando(){
        // Act
        ciudadano1.morir();
        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano1.accionDiurna(fase, ciudadano2),
                "Un jugador muerto puede seguir votando");
    }
}
