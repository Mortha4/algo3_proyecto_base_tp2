package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.roles.Detective;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DetectiveTest {
    private Detective detective;

    @BeforeEach
    public void arrange() {
        detective = new Detective();
    }

}
