package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
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
        Rol result = mafioso.verBando(mafiosoObservado);

        // Assert
        assertEquals(result, mafiosoObservado, "El mafioso no pudo ver el bando de otro mafioso");
    }

    @Test
    public void test02MafiosoNoPuedeVerUnCiudadano(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Ciudadano ciudadanoObservado = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(ciudadanoObservado),
                "El mafioso no pudo ver el bando de un ciudadano");
    }

    @Test
    public void test03MafiosoNoPuedeVerUnSheriff(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Sheriff sheriffObservado = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(sheriffObservado),
                "El mafioso no pudo ver el bando de un sheriff");
    }
    @Test
    public void test04MafiosoNoPuedeVerUnDetective(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Detective detectiveObservado = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(detectiveObservado),
                "El mafioso no pudo ver el bando de un detective");
    }
    @Test
    public void test05MafiosoNoPuedeVerUnMedico(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Medico medicoObservado = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(medicoObservado),
                "El mafioso no pudo ver el bando de un medico");
    }
    @Test
    public void test06MafiosoPuedeVerUnPadrino(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Padrino padrinoObservado = new Padrino();

        // Act
        Rol result = mafioso.verBando(padrinoObservado);

        // Assert
        assertEquals(new Mafioso(), result, "El mafioso no pudo observar un padrino.");
    }


}
