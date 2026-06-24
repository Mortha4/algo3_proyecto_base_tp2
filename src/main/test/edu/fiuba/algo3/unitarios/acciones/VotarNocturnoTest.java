package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.VotarNocturno;
import edu.fiuba.algo3.modelo.excepciones.VotacionEntreMafiososException;
import edu.fiuba.algo3.modelo.excepciones.VotarAlMismoJugadorException;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VotarNocturnoTest {
    private FaseNocturna fase;
    private Jugador ciudadano;
    private Jugador mafioso1;
    private Jugador mafioso2;

    @BeforeEach
    public void arrange() {
        fase = new FaseNocturna();
        ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        mafioso2 = new Jugador(new Mafioso(), "mafioso2");
    }

    @Test
    public void test01UnVotoNocturnoPuedeEliminarAUnCiudadano() {
        // Arrange
        VotarNocturno votar = new VotarNocturno(fase, mafioso1, ciudadano);

        // Act
        votar.execute();
        fase.finalizar();

        // Assert
        assertFalse(ciudadano.estaVivo(),
                "Un voto nocturno debería poder eliminar a un ciudadano");
        assertTrue(mafioso1.estaVivo(),
                "El mafioso que vota no debería ser eliminado por votar");
    }

    @Test
    public void test02LaFaseNocturnaPuedeEjecutarUnVotoNocturno() {
        // Arrange
        VotarNocturno votar = new VotarNocturno(fase, mafioso1, ciudadano);

        // Act
        fase.ejecutarComando(votar);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano.estaVivo(),
                "La fase nocturna debería poder ejecutar un voto nocturno");
    }

    @Test
    public void test03UnMafiosoNoPuedeVotarAOtroMafiosoDuranteLaNoche() {
        // Act y Assert
        assertThrows(NoVotableException.class,
                () -> new VotarNocturno(fase, mafioso1, mafioso2),
                "Un mafioso no debería poder votar a otro mafioso durante la noche");
    }

    @Test
    public void test04UnMafiosoNoPuedeVotarseASiMismoDuranteLaNoche() {
        // Act y Assert
        assertThrows(VotarAlMismoJugadorException.class,
                () -> new VotarNocturno(fase, mafioso1, mafioso1),
                "Un mafioso no debería poder votarse a sí mismo durante la noche");
    }
}
