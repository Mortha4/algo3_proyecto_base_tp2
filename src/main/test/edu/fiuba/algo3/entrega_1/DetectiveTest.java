package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DetectiveTest {
    @Test
    public void test01DetectivePuedeVerUnDetective(){
        // Arrange
        Detective detective = new Detective();
        Detective otroDetective = new Detective();

        // Act
        Rol result = detective.verBando(otroDetective);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un detective");
    }
    @Test
    public void test02DetectivePuedeVerUnMedico(){
        // Arrange
        Detective detective = new Detective();
        Medico medico = new Medico();

        // Act
        Rol result = detective.verBando(medico);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un medico");

    }
    @Test
    public void test03DetectivePuedeVerUnCiudadano(){
        // Arrange
        Detective detective = new Detective();
        Ciudadano ciudadano = new Ciudadano();

        // Act
        Rol result = detective.verBando(ciudadano);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un ciudadano");

    }
    @Test
    public void test04DetectivePuedeVerUnSheriff(){
        // Arrange
        Detective detective = new Detective();
        Sheriff sheriff = new Sheriff();

        // Act
        Rol result = detective.verBando(sheriff);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un sheriff");

    }
    @Test
    public void test05DetectivePuedeVerUnMafioso(){
        // Arrange
        Detective detective = new Detective();
        Mafioso mafioso = new Mafioso();

        // Act
        Rol result = detective.verBando(mafioso);

        // Assert
        assertEquals(Mafioso.class, result.getClass(),
                "Un detective no puede ver el bando de un mafioso");

    }
    @Test
    public void test06DetectivePuedeVerUnPadrino(){
        // Arrange
        Detective detective = new Detective();
        Padrino padrino = new Padrino();

        // Act
        Rol result = detective.verBando(padrino);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un padrino");

    }
}
