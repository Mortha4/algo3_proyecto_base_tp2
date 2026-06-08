package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.excepciones.NoVisible;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MafiosoTest {
    @Test
    public void test01MafiosoPuedeVerUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Mafioso mafiosoObservado = new Mafioso();

        // Act
        RolVisitable result = mafioso.verRol(mafiosoObservado);

        // Assert
        assertEquals(result, mafiosoObservado, "El mafioso no pudo observar a otro mafioso.");
    }

    @Test
    public void test02MafiosoNoPuedeVerUnCiudadano(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Ciudadano ciudadanoObservado = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisible.class, () -> mafioso.verRol(ciudadanoObservado));
    }

    @Test
    public void test03MafiosoNoPuedeVerUnSheriff(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Sheriff sheriffObservado = new Sheriff();

        // Act y Assert
        assertThrows(NoVisible.class, () -> mafioso.verRol(sheriffObservado));
    }
    @Test
    public void test04MafiosoNoPuedeVerUnDetective(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Detective detectiveObservado = new Detective();

        // Act y Assert
        assertThrows(NoVisible.class, () -> mafioso.verRol(detectiveObservado));
    }
    @Test
    public void test05MafiosoNoPuedeVerUnMedico(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Medico medicoObservado = new Medico();

        // Act y Assert
        assertThrows(NoVisible.class, () -> mafioso.verRol(medicoObservado));
    }
    @Test
    public void test06MafiosoPuedeVerUnPadrino(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Padrino padrinoObservado = new Padrino();

        // Act
        RolVisitable result = mafioso.verRol(padrinoObservado);

        // Assert
        assertEquals(result, padrinoObservado, "El mafioso no pudo observar a otro mafioso.");
    }


}
