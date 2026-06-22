package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Nada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NadaTest {
    @Test
    public void test01ExecuteNoRealizaNingunaAccion() {
        // Arrange
        Nada nada = new Nada();

        // Act y Assert
        assertDoesNotThrow(nada::execute,
                "La acción Nada no debería lanzar excepciones al ejecutarse");
    }
}
