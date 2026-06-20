package edu.fiuba.algo3.unitarios.roles;


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
    public void test01MafiosoNoPuedeVerBandoDeUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(ciudadano),
                "Un mafioso no debería poder ver el bando de un ciudadano");
    }

    @Test
    public void test02MafiosoNoPuedeVerBandoDeUnMedico(){
        // Arrange
        Medico medico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(medico),
                "Un mafioso no debería poder ver el bando de un médico");
    }

    @Test
    public void test03MafiosoNoPuedeVerBandoDeUnDetective(){
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(detective),
                "Un mafioso no debería poder ver el bando de un detective");
    }

    @Test
    public void test04MafiosoNoPuedeVerBandoDeUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(sheriff),
                "Un mafioso no debería poder ver el bando de un sheriff");
    }

    @Test
    public void test05MafiosoPuedeVerBandoDeOtroMafioso(){
        // Arrange
        Mafioso otroMafioso = new Mafioso();

        // Act
        Rol result = mafioso.verBando(otroMafioso);

        // Assert
        assertEquals(new Mafioso(), result,
                "Un mafioso debería poder ver el bando de otro mafioso");
    }

    @Test
    public void test06MafiosoPuedeVerBandoDeUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act
        Rol result = mafioso.verBando(padrino);

        // Assert
        assertEquals(new Mafioso(), result,
                "Un mafioso debería poder ver el bando de un padrino");
    }
}
