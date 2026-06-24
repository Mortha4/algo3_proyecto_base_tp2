package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Proteger;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProtegerDosVecesSeguidasException;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoProtegidoException;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProtegerTest {
    private FaseNocturna fase;
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private Jugador mafioso;

    @BeforeEach
    public void arrange() {
        fase = new FaseNocturna();
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        mafioso = new Jugador(new Mafioso(), "mafioso");
    }

    @Test
    public void test01ProtegerImpideQueElJugadorVotadoSeaEliminado() {
        // Arrange
        Proteger proteger = new Proteger(fase, ciudadano1);
        Votar votar = new Votar(fase, mafioso, ciudadano1);

        // Act
        proteger.execute();
        votar.execute();

        // Assert
        assertThrows(ObjetivoProtegidoException.class, fase::finalizar,
                "Un jugador protegido no debería ser eliminado durante la fase nocturna");
        assertTrue(ciudadano1.estaVivo(),
                "Un jugador protegido debería seguir vivo");
    }

    @Test
    public void test02LaFaseNocturnaPuedeEjecutarProteger() {
        // Arrange
        Proteger proteger = new Proteger(fase, ciudadano1);
        Votar votar = new Votar(fase, mafioso, ciudadano1);

        // Act
        fase.ejecutar(proteger);
        fase.ejecutar(votar);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, fase::finalizar,
                "La fase nocturna debería poder ejecutar la acción proteger");
        assertTrue(ciudadano1.estaVivo(),
                "Un jugador protegido debería seguir vivo");
    }

    @Test
    public void test03NoSePuedeProtegerDosVecesSeguidasAlMismoJugador() {
        // Arrange
        Proteger primeraProteccion = new Proteger(fase, ciudadano1);
        Proteger segundaProteccion = new Proteger(fase, ciudadano1);

        // Act
        primeraProteccion.execute();

        // Assert
        assertThrows(NoSePuedeProtegerDosVecesSeguidasException.class, segundaProteccion::execute,
                "No se debería poder proteger dos veces seguidas al mismo jugador");
    }

    @Test
    public void test04SePuedeProtegerAOtroJugadorLuegoDeUnaProteccion() {
        // Arrange
        Proteger primeraProteccion = new Proteger(fase, ciudadano1);
        Proteger segundaProteccion = new Proteger(fase, ciudadano2);
        Votar votar = new Votar(fase, mafioso, ciudadano1);

        // Act
        primeraProteccion.execute();
        segundaProteccion.execute();
        votar.execute();
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "El jugador que dejó de estar protegido debería poder ser eliminado");
        assertTrue(ciudadano2.estaVivo(),
                "El nuevo jugador protegido debería seguir vivo");
    }
}
