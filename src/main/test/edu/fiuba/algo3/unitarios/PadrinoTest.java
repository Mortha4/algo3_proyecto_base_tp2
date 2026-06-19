package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PadrinoTest {
    private Padrino padrino;

    @BeforeEach
    public void arrange() {
        padrino = new Padrino();
    }

    @Test
    public void test01PadrinoNoPuedeVerBandoDeUnCiudadano(){
        // Arrange
        Ciudadano ciudadanoObservado = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(ciudadanoObservado),
                "Un padrino no debería poder ver el bando de un ciudadano");
    }

    @Test
    public void test02PadrinoNoPuedeVerBandoDeUnMedico(){
        // Arrange
        Medico medicoObservado = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(medicoObservado),
                "Un padrino no debería poder ver el bando de un médico");
    }

    @Test
    public void test03PadrinoNoPuedeVerBandoDeUnDetective(){
        // Arrange
        Detective detectiveObservado = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(detectiveObservado),
                "Un padrino no debería poder ver el bando de un detective");
    }

    @Test
    public void test04PadrinoNoPuedeVerBandoDeUnSheriff(){
        // Arrange
        Sheriff sheriffObservado = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(sheriffObservado),
                "Un padrino no debería poder ver el bando de un sheriff");
    }

    @Test
    public void test05PadrinoPuedeVerBandoDeUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act
        Rol result = padrino.verBando(mafioso);

        // Assert
        assertEquals(new Mafioso(), result,
                "Un padrino debería poder ver el bando de un mafioso");
    }

    @Test
    public void test06PadrinoPuedeVerBandoDeOtroPadrino(){
        // Arrange
        Padrino otroPadrino = new Padrino();

        // Act
        Rol result = padrino.verBando(otroPadrino);

        // Assert
        assertEquals(new Mafioso(), result,
                "Un padrino debería poder ver el bando de otro padrino");
    }
}

