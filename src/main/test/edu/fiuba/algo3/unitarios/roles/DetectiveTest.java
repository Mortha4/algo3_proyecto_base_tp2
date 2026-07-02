package edu.fiuba.algo3.unitarios.roles;

import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectiveTest {
    private Detective detective;

    @BeforeEach
    public void arrange() {
        detective = new Detective();
    }

    @Test
    public void test01DetectivePuedeIdentificarAUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act
        Rol result = detective.verBando(ciudadano);

        // Assert
        assertEquals(new Ciudadano(), result,
                "El detective debería identificar a un ciudadano como ciudadano.");
    }

    @Test
    public void test02DetectivePuedeIdentificarAUnMedico(){
        // Arrange
        Medico medico = new Medico();

        // Act
        Rol result = detective.verBando(medico);

        // Assert
        assertEquals(new Ciudadano(), result,
                "El detective debería identificar a un médico como ciudadano.");
    }

    @Test
    public void test03DetectivePuedeIdentificarAOtroDetective(){
        // Arrange
        Detective otroDetective = new Detective();

        // Act
        Rol result = detective.verBando(otroDetective);

        // Assert
        assertEquals(new Ciudadano(), result,
                "El detective debería identificar a otro detective como ciudadano.");
    }

    @Test
    public void test04DetectivePuedeIdentificarAUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act
        Rol result = detective.verBando(sheriff);

        // Assert
        assertEquals(new Ciudadano(), result,
                "El detective debería identificar a un sheriff como ciudadano.");
    }

    @Test
    public void test05DetectivePuedeIdentificarAUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act
        Rol result = detective.verBando(mafioso);

        // Assert
        assertEquals(new Mafioso(), result,
                "El detective debería identificar a un mafioso como mafioso.");
    }

    @Test
    public void test06DetectivePuedeIdentificarAUnPadrinoComoCiudadano(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act
        Rol result = detective.verBando(padrino);

        // Assert
        assertEquals(new Ciudadano(), result,
                "El detective debería identificar al padrino como ciudadano.");
    }
}
