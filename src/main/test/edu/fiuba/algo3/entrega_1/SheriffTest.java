package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.NoVisible;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SheriffTest {
    @Test
    public void test01SheriffNoPuedeVerUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();
        Sheriff otroSheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisible.class, () -> sheriff.verBando(otroSheriff),
                "El sheriff pudo ver el bando de un ciudadano");
    }
    @Test
    public void test02SheriffNoPuedeVerUnCiudadano(){
        // Arrange
        Sheriff sheriff = new Sheriff();
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisible.class, () -> sheriff.verBando(ciudadano),
                "El sheriff pudo ver el bando de un ciudadano");
    }
    @Test
    public void test03SheriffNoPuedeVerUnDetective(){
        // Arrange
        Sheriff sheriff = new Sheriff();
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisible.class, () -> sheriff.verBando(detective),
                "El sheriff pudo ver el bando de un ciudadano");
    }
    @Test
    public void test04SheriffNoPuedeVerUnMedico(){
        // Arrange
        Sheriff sheriff = new Sheriff();
        Medico medico = new Medico();

        // Act y Assert
        assertThrows(NoVisible.class, () -> sheriff.verBando(medico),
                "El sheriff pudo ver el bando de un ciudadano");
    }
    @Test
    public void test05SheriffNoPuedeVerUnMafioso(){
        // Arrange
        Sheriff sheriff = new Sheriff();
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisible.class, () -> sheriff.verBando(mafioso),
                "El sheriff pudo ver el bando de un mafioso");
    }
    @Test
    public void test06SheriffNoPuedeVerUnPadrino(){
        // Arrange
        Sheriff sheriff = new Sheriff();
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisible.class, () -> sheriff.verBando(padrino),
                "El sheriff pudo ver el bando de un mafioso");
    }
}
