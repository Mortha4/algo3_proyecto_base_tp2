package edu.fiuba.algo3.unitarios.acciones;
import edu.fiuba.algo3.modelo.acciones.Revelar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.SinMuerte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Sheriff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RevelarTest {
    private FaseDiurna fase;
    private Jugador revelador;

    @BeforeEach
    public void arrange(){
        fase = new FaseDiurna(new SinMuerte());
        revelador = new Jugador(new Sheriff(), "sheriff");
    }

    @Test
    public void test01SePuedeRevelarASiMismo(){
        // Act y Assert
        assertDoesNotThrow( () -> new Revelar(fase, revelador, revelador),
                "Debería poder revelarse una investigación hecha sobre uno mismo.");
    }
}
