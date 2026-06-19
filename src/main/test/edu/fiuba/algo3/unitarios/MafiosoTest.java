package edu.fiuba.algo3.unitarios;


import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MafiosoTest {
    private Mafioso mafioso;

    @BeforeEach
    public void arrange() {
        mafioso = new Mafioso();
    }

    @Test
    public void test01MafiosoNoPuedeVerUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(ciudadano),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test02MafiosoNoPuedeVerUnMedico(){
        // Arrange
        Medico medico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(medico),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test03MafiosoNoPuedeVerUnDetective(){
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(detective),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test04MafiosoNoPuedeVerUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(sheriff),
                "Un ciudadano puede ver el bando de otro ciudadano");
    }

    @Test
    public void test05MafiosoPuedeVerUnMafioso(){
        // Arrange
        Mafioso otroMafioso = new Mafioso();

        // Act
        Rol result = mafioso.verBando(otroMafioso);

        // Assert
        assertEquals(new Mafioso(), result, "el mafioso no pudo ver el bando de otro mafioso");
    }

    @Test
    public void test06MafiosoPuedeVerUnPadrino(){
        // Arrange
        Mafioso otroMafioso = new Mafioso();

        // Act
        Rol result = mafioso.verBando(otroMafioso);

        // Assert
        assertEquals(new Mafioso(), result, "el mafioso no pudo ver el bando de otro mafioso");
    }
}
