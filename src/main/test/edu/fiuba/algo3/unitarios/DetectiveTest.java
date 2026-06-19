package edu.fiuba.algo3.unitarios;

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
    public void test01DetectivePuedeVerUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act
        Rol result = detective.verBando(ciudadano);

        // Assert
        assertEquals(new Ciudadano(), result, "El detective no pudo observar a un ciudadano.");
    }

    @Test
    public void test02DetectivePuedeVerUnMedico(){
        // Arrange
        Medico medico = new Medico();

        // Act
        Rol result = detective.verBando(medico);

        // Assert
        assertEquals(new Ciudadano(), result, "El detective no pudo observar a un médico.");
    }

    @Test
    public void test03DetectivePuedeVerUnDetective(){
        // Arrange
        Detective otroDetective = new Detective();

        // Act
        Rol result = detective.verBando(otroDetective);

        // Assert
        assertEquals(new Ciudadano(), result, "El detective no pudo observar a otro detective.");
    }

    @Test
    public void test04DetectivePuedeVerUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act
        Rol result = detective.verBando(sheriff);

        // Assert
        assertEquals(new Ciudadano(), result, "El detective no pudo observar a un sheriff.");
    }

    @Test
    public void test05DetectivePuedeVerUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act
        Rol result = detective.verBando(mafioso);

        // Assert
        assertEquals(new Mafioso(), result, "El detective no pudo observar a un sheriff.");
    }

    @Test
    public void test06DetectivePuedeVerUnPadrinoComoCiudadano(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act
        Rol result = detective.verBando(padrino);

        // Assert
        assertEquals(new Ciudadano(), result, "El detective no pudo observar a un padrino como ciudadano.");
    }
}
