package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedicoTest {
    @Test
    public void test01MedicoNoPuedeVerUnMedico(){
        // Arrange
        Medico medico = new Medico();
        Medico otroMedico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(otroMedico),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test02MedicoNoPuedeVerUnCiudadano(){
        // Arrange
        Medico medico = new Medico();
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(ciudadano),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test03MedicoNoPuedeVerUnDetective(){
        // Arrange
        Medico medico = new Medico();
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(detective),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test04MedicoNoPuedeVerUnSheriff(){
        // Arrange
        Medico medico = new Medico();
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(sheriff),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test05MedicoNoPuedeVerUnMafioso(){
        // Arrange
        Medico medico = new Medico();
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(mafioso),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test06MedicoNoPuedeVerUnPadrino(){
        // Arrange
        Medico medico = new Medico();
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(padrino),
                "El medico pudo ver el bando de un ciudadano");
    }
}
