package edu.fiuba.algo3.unitarios;

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
    public void test01CiudadanoNoPuedeVerUnCiudadano(){
        // Arrange
        Ciudadano otroCiudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(otroCiudadano),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test02CiudadanoNoPuedeVerUnMedico(){
        // Arrange
        Medico medico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(medico),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test03CiudadanoNoPuedeVerUnDetective(){
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(detective),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test04CiudadanoNoPuedeVerUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(sheriff),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test05CiudadanoNoPuedeVerUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(mafioso),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test06CiudadanoNoPuedeVerUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano.verBando(padrino),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

}
