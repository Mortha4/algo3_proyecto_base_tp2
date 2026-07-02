package edu.fiuba.algo3.unitarios.roles;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CiudadanoTest {
    private Ciudadano ciudadano;

    @BeforeEach
    public void arrange() {
        ciudadano = new Ciudadano();
    }

    @Test
    public void test01CiudadanoNoPuedeVerBandoDeOtroCiudadano() {
        // Arrange
        Ciudadano otroCiudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(otroCiudadano),
                "Un ciudadano no debería poder ver el bando de otro ciudadano");
    }

    @Test
    public void test02CiudadanoNoPuedeVerBandoDeUnMedico() {
        // Arrange
        Medico medico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(medico),
                "Un ciudadano no debería poder ver el bando de un médico");
    }

    @Test
    public void test03CiudadanoNoPuedeVerBandoDeUnDetective() {
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(detective),
                "Un ciudadano no debería poder ver el bando de un detective");
    }

    @Test
    public void test04CiudadanoNoPuedeVerBandoDeUnSheriff() {
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(sheriff),
                "Un ciudadano no debería poder ver el bando de un sheriff");
    }

    @Test
    public void test05CiudadanoNoPuedeVerBandoDeUnMafioso() {
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(mafioso),
                "Un ciudadano no debería poder ver el bando de un mafioso");
    }

    @Test
    public void test06CiudadanoNoPuedeVerBandoDeUnPadrino() {
        // Arrange
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(padrino),
                "Un ciudadano no debería poder ver el bando de un padrino");
    }

}
