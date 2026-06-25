package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Investigar;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeInvestigarDosVecesSeguidasException;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Detective;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvestigarTest {
    private FaseNocturna fase;
    private Jugador detective;
    private Jugador ciudadano;
    private Jugador mafioso;

    @BeforeEach
    public void arrange() {
        fase = new FaseNocturna();
        detective = new Jugador(new Detective(), "detective");
        ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        mafioso = new Jugador(new Mafioso(), "mafioso");
    }

    @Test
    public void test01InvestigarUnCiudadanoNoLanzaExcepciones() {
        // Arrange
        Investigar investigar = new Investigar(fase, detective, ciudadano);

        // Act y Assert
        assertDoesNotThrow(investigar::execute,
                "Investigar a un ciudadano no debería lanzar excepciones");
        assertTrue(ciudadano.estaVivo(),
                "Investigar no debería eliminar al jugador investigado");
    }

    @Test
    public void test02InvestigarUnMafiosoNoLanzaExcepciones() {
        // Arrange
        Investigar investigar = new Investigar(fase, detective, mafioso);

        // Act y Assert
        assertDoesNotThrow(investigar::execute,
                "Investigar a un mafioso no debería lanzar excepciones");
        assertTrue(mafioso.estaVivo(),
                "Investigar no debería eliminar al jugador investigado");
    }

    @Test
    public void test03LaFaseNocturnaPuedeEjecutarInvestigar() {
        // Arrange
        Investigar investigar = new Investigar(fase, detective, ciudadano);

        // Act y Assert
        assertDoesNotThrow(() -> fase.ejecutar(investigar),
                "La fase nocturna debería poder ejecutar la acción investigar");
    }

    @Test
    public void test04NoSePuedeInvestigarDosVecesSeguidasAlMismoJugador() {
        // Arrange
        Investigar primeraInvestigacion = new Investigar(fase, detective, ciudadano);
        Investigar segundaInvestigacion = new Investigar(fase, detective, ciudadano);

        // Act
        primeraInvestigacion.execute();

        // Assert
        assertThrows(NoSePuedeInvestigarDosVecesSeguidasException.class, segundaInvestigacion::execute,
                "No se debería poder investigar dos veces seguidas al mismo jugador");
    }

    @Test
    public void test05SePuedeInvestigarAOtroJugadorLuegoDeUnaInvestigacion() {
        // Arrange
        Investigar primeraInvestigacion = new Investigar(fase, detective, ciudadano);
        Investigar segundaInvestigacion = new Investigar(fase, detective, mafioso);

        // Act y Assert
        primeraInvestigacion.execute();
        assertDoesNotThrow(segundaInvestigacion::execute,
                "Se debería poder investigar a otro jugador luego de una investigación");
    }
}
