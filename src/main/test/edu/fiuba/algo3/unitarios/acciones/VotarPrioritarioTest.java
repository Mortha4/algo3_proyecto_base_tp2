package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.acciones.VotarPrioritario;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.VotarAlMismoJugadorException;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Padrino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VotarPrioritarioTest {
    private FaseNocturna fase;
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private Jugador mafioso;
    private Jugador padrino;

    @BeforeEach
    public void arrange() {
        fase = new FaseNocturna();
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        mafioso = new Jugador(new Mafioso(), "mafioso");
        padrino = new Jugador(new Padrino(), "padrino");
    }

    @Test
    public void test01ElVotoPrioritarioSeRegistraAlEjecutarse() {
        // Arrange
        VotarPrioritario votoPrioritario = new VotarPrioritario(fase, padrino, ciudadano1);

        // Act
        votoPrioritario.execute();
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "El voto prioritario debería registrar un voto contra el objetivo");
        assertTrue(padrino.estaVivo(),
                "El padrino que vota no debería ser eliminado por votar");
    }

    @Test
    public void test02ElVotoPrioritarioDesempataLaVotacion() {
        // Arrange
        Votar votoMafioso = new Votar(fase, mafioso, ciudadano1);
        VotarPrioritario votoPadrino = new VotarPrioritario(fase, padrino, ciudadano2);

        // Act
        votoMafioso.execute();
        votoPadrino.execute();
        fase.finalizar();

        // Assert
        assertFalse(ciudadano2.estaVivo(),
                "El voto prioritario debería desempatar a favor de su objetivo");
        assertTrue(ciudadano1.estaVivo(),
                "El jugador empatado sin voto prioritario no debería ser eliminado");
    }

    @Test
    public void test03LaFaseNocturnaPuedeEjecutarUnVotoPrioritario() {
        // Arrange
        VotarPrioritario votoPrioritario = new VotarPrioritario(fase, padrino, ciudadano1);

        // Act
        fase.ejecutar(votoPrioritario);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "La fase nocturna debería poder ejecutar un voto prioritario");
    }

    @Test
    public void test04UnJugadorNoPuedeVotarseASiMismoConVotoPrioritario() {
        // Act y Assert
        assertThrows(VotarAlMismoJugadorException.class,
                () -> new VotarPrioritario(fase, padrino, padrino),
                "Un jugador no debería poder votarse a sí mismo con voto prioritario");
    }
}
