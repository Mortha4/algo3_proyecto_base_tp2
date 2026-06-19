package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PadrinoTest {
    private Padrino padrino;

    @BeforeEach
    public void arrange() {
        padrino = new Padrino();
    }

    @Test
    public void test01PadrinoPuedeVerUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();
        Padrino padrinoObservado = new Padrino();

        // Act
        Rol result = padrino.verBando(padrinoObservado);

        // Assert
        assertEquals(new Mafioso(), result, "El padrino no pudo observar a otro padrino.");
    }

    @Test
    public void test02PadrinoNoPuedeVerUnCiudadano(){
        // Arrange
        Padrino padrino = new Padrino();
        Ciudadano ciudadanoObservado = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(ciudadanoObservado),
                "El padrino pudo ver el bando de un ciudadano");
    }

    @Test
    public void test03PadrinoNoPuedeVerUnSheriff(){
        // Arrange
        Padrino padrino = new Padrino();
        Sheriff sheriffObservado = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(sheriffObservado),
                "El padrino pudo ver el bando de un ciudadano");
    }
    @Test
    public void test04PadrinoNoPuedeVerUnDetective(){
        // Arrange
        Padrino padrino = new Padrino();
        Detective detectiveObservado = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(detectiveObservado),
                "El padrino pudo ver el bando de un ciudadano");
    }
    @Test
    public void test05PadrinoNoPuedeVerUnMedico(){
        // Arrange
        Padrino padrino = new Padrino();
        Medico medicoObservado = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> padrino.verBando(medicoObservado),
                "El padrino pudo ver el bando de un ciudadano");
    }
    @Test
    public void test06PadrinoPuedeVerUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();
        Mafioso mafioso = new Mafioso();

        // Act
        Rol result = padrino.verBando(mafioso);

        // Assert
        assertEquals(new Mafioso(), result, "el padrino no pudo ver el bando de otro padrino");
    }
}

