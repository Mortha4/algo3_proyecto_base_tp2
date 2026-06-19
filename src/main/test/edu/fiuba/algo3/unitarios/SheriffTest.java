package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SheriffTest {
    private Sheriff sheriff;

    @BeforeEach
    public void arrange() {
        sheriff = new Sheriff();
    }

    @Test
    public void test01SheriffNoPuedeVerBandoDeUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(ciudadano),
                "Un sheriff no debería poder ver el bando de un ciudadano");
    }

    @Test
    public void test02SheriffNoPuedeVerBandoDeUnMedico(){
        // Arrange
        Medico medico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(medico),
                "Un sheriff no debería poder ver el bando de un médico");
    }

    @Test
    public void test03SheriffNoPuedeVerBandoDeUnDetective(){
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(detective),
                "Un sheriff no debería poder ver el bando de un detective");
    }

    @Test
    public void test04SheriffNoPuedeVerBandoDeOtroSheriff(){
        // Arrange
        Sheriff otroSheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(otroSheriff),
                "Un sheriff no debería poder ver el bando de otro sheriff");
    }

    @Test
    public void test05SheriffNoPuedeVerBandoDeUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(mafioso),
                "Un sheriff no debería poder ver el bando de un mafioso");
    }

    @Test
    public void test06SheriffNoPuedeVerBandoDeUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(padrino),
                "Un sheriff no debería poder ver el bando de un padrino");
    }
}
