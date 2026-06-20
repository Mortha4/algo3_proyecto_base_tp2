package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VisitanteMafiosoTest {
    private VisitanteMafioso visitante;

    @BeforeEach
    public void arrange() {
        visitante = new VisitanteMafioso();
    }

    @Test
    public void test01UnMafiosoVeAUnMafiosoComoMafioso() {
        // Act y Assert
        assertEquals(new Mafioso(), visitante.visitar(new Mafioso()),
                "Un mafioso debería ver a otro mafioso como mafioso");
    }

    @Test
    public void test02UnMafiosoVeAUnPadrinoComoMafioso() {
        // Act y Assert
        assertEquals(new Mafioso(), visitante.visitar(new Padrino()),
                "Un mafioso debería ver a un padrino como mafioso");
    }

    @Test
    public void test03UnMafiosoNoPuedeVerAUnCiudadano() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Ciudadano()),
                "Un mafioso no debería poder ver el bando de un ciudadano");
    }

    @Test
    public void test04UnMafiosoNoPuedeVerAUnMedico() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Medico()),
                "Un mafioso no debería poder ver el bando de un médico");
    }

    @Test
    public void test05UnMafiosoNoPuedeVerAUnDetective() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Detective()),
                "Un mafioso no debería poder ver el bando de un detective");
    }

    @Test
    public void test06UnMafiosoNoPuedeVerAUnSheriff() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Sheriff()),
                "Un mafioso no debería poder ver el bando de un sheriff");
    }
}
