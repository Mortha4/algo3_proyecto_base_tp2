package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.acciones.NoActuar;
import edu.fiuba.algo3.modelo.acciones.Nominar;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.fase.SinMuerte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoActuarTest {
    private Jugador ciudadano;
    private Jugador mafioso;
    private Accion noActuar;

    @BeforeEach
    public void arrange(){
        ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        mafioso =  new Jugador(new Mafioso(), "mafioso");
        noActuar = new NoActuar();
    }

    @Test
    public void test01ExecuteNoRealizaNingunaAccion() {
        // Act y Assert
        assertDoesNotThrow(noActuar::execute,
                "La acción NoActuar no debería lanzar excepciones al ejecutarse");
    }

    @Test
    public void test02NoActuarNoInterfiereConUnaVotacionDiurna() {
        // Arrange
        FaseDiurna fase = new FaseDiurna(new SinMuerte());
        fase.nominar(ciudadano, mafioso);
        Votar votar = new Votar(fase, ciudadano, mafioso);

        // Act
        fase.ejecutar(noActuar);
        fase.ejecutar(votar);
        fase.finalizar();

        // Assert
        assertFalse(mafioso.estaVivo(),
                "La acción NoActuar no debería impedir que se resuelva una votación diurna");
        assertTrue(ciudadano.estaVivo(),
                "La acción NoActuar no debería afectar al jugador que sigue vivo");
    }

    @Test
    public void test03NoActuarNoInterfiereConUnaVotacionNocturna() {
        // Arrange
        FaseNocturna fase = new FaseNocturna();
        fase.ejecutar(new Nominar(fase, mafioso, ciudadano));
        Votar votar = new Votar(fase, mafioso, ciudadano);

        // Act
        fase.ejecutar(noActuar);
        fase.ejecutar(votar);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano.estaVivo(),
                "La acción NoActuar no debería impedir que se resuelva una votación nocturna");
        assertTrue(mafioso.estaVivo(),
                "La acción NoActuar no debería afectar al jugador que sigue vivo");
    }
}
