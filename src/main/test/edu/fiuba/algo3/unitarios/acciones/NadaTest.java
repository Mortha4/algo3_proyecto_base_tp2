package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Nada;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NadaTest {
    @Test
    public void test01ExecuteNoRealizaNingunaAccion() {
        // Arrange
        Nada nada = new Nada();

        // Act y Assert
        assertDoesNotThrow(nada::execute,
                "La acción Nada no debería lanzar excepciones al ejecutarse");
    }

    @Test
    public void test02NadaNoInterfiereConUnaVotacionDiurna() {
        // Arrange
        FaseDiurna fase = new FaseDiurna();
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        Nada nada = new Nada();
        Votar votar = new Votar(fase, ciudadano, mafioso);

        // Act
        fase.ejecutar(nada);
        fase.ejecutar(votar);
        fase.finalizar();

        // Assert
        assertFalse(mafioso.estaVivo(),
                "La acción Nada no debería impedir que se resuelva una votación diurna");
        assertTrue(ciudadano.estaVivo(),
                "La acción Nada no debería afectar al jugador que sigue vivo");
    }

    @Test
    public void test03NadaNoInterfiereConUnaVotacionNocturna() {
        // Arrange
        FaseNocturna fase = new FaseNocturna();
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        Nada nada = new Nada();
        Votar votar = new Votar(fase, mafioso, ciudadano);

        // Act
        fase.ejecutar(nada);
        fase.ejecutar(votar);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano.estaVivo(),
                "La acción Nada no debería impedir que se resuelva una votación nocturna");
        assertTrue(mafioso.estaVivo(),
                "La acción Nada no debería afectar al jugador que sigue vivo");
    }
}
