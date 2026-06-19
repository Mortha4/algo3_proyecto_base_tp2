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
    public void test01SheriffNoPuedeVerUnSheriff(){
        // Arrange
        Sheriff otroSheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(otroSheriff),
                "El sheriff pudo ver el bando de un ciudadano");
    }

    @Test
    public void test02SheriffNoPuedeVerUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(ciudadano),
                "El sheriff pudo ver el bando de un ciudadano");
    }

    @Test
    public void test03SheriffNoPuedeVerUnDetective(){
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(detective),
                "El sheriff pudo ver el bando de un ciudadano");
    }

    @Test
    public void test04SheriffNoPuedeVerUnMedico(){
        // Arrange
        Medico medico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(medico),
                "El sheriff pudo ver el bando de un ciudadano");
    }

    @Test
    public void test05SheriffNoPuedeVerUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(mafioso),
                "El sheriff pudo ver el bando de un mafioso");
    }

    @Test
    public void test06SheriffNoPuedeVerUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> sheriff.verBando(padrino),
                "El sheriff pudo ver el bando de un mafioso");
    }
}
