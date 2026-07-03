package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.acciones.Nada;
import edu.fiuba.algo3.modelo.acciones.Nominar;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.fase.SinMuerte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.unitarios.fase.PartidaMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NadaTest {
    private Jugador ciudadano;
    private Jugador mafioso;
    private Accion nada;
    private PartidaMock partidaMock;

    @BeforeEach
    public void arrange(){
        partidaMock = new PartidaMock(List.of("1", "2", "3", "4", "5"));
        ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        mafioso =  new Jugador(new Mafioso(), "mafioso");
        nada = new Nada();
    }

    @Test
    public void test01ExecuteNoRealizaNingunaAccion() {
        // Act y Assert
        assertDoesNotThrow(nada::execute,
                "La acción Nada no debería lanzar excepciones al ejecutarse");
    }

    @Test
    public void test02NadaNoInterfiereConUnaVotacionDiurna() {
        // Arrange
        FaseDiurna fase = new FaseDiurna(new SinMuerte());
        fase.nominar(ciudadano, mafioso);
        Votar votar = new Votar(fase, ciudadano, mafioso);

        // Act
        fase.ejecutar(nada);
        fase.ejecutar(votar);
        fase.finalizar(partidaMock);

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
        fase.ejecutar(new Nominar(fase, mafioso, ciudadano));
        Votar votar = new Votar(fase, mafioso, ciudadano);

        // Act
        fase.ejecutar(nada);
        fase.ejecutar(votar);
        fase.finalizar(partidaMock);

        // Assert
        assertFalse(ciudadano.estaVivo(),
                "La acción Nada no debería impedir que se resuelva una votación nocturna");
        assertTrue(mafioso.estaVivo(),
                "La acción Nada no debería afectar al jugador que sigue vivo");
    }
}
