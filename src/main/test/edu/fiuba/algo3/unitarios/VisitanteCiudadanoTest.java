package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;
import edu.fiuba.algo3.modelo.visitors.VisitanteCiudadano;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VisitanteCiudadanoTest {
    private VisitanteCiudadano visitante;

    @BeforeEach
    public void arrange() {
        visitante = new VisitanteCiudadano();
    }

    @Test
    public void test01UnCiudadanoNoPuedeVerAUnCiudadano() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Ciudadano()),
                "Un ciudadano no debería poder ver el bando de un ciudadano");
    }

    @Test
    public void test02UnCiudadanoNoPuedeVerAUnMafioso() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Mafioso()),
                "Un ciudadano no debería poder ver el bando de un mafioso");
    }

    @Test
    public void test03UnCiudadanoNoPuedeVerAUnPadrino() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Padrino()),
                "Un ciudadano no debería poder ver el bando de un padrino");
    }

    @Test
    public void test04UnCiudadanoNoPuedeVerAUnMedico() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Medico()),
                "Un ciudadano no debería poder ver el bando de un médico");
    }

    @Test
    public void test05UnCiudadanoNoPuedeVerAUnDetective() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Detective()),
                "Un ciudadano no debería poder ver el bando de un detective");
    }

    @Test
    public void test06UnCiudadanoNoPuedeVerAUnSheriff() {
        // Act y Assert
        assertThrows(NoVisibleException.class, () -> visitante.visitar(new Sheriff()),
                "Un ciudadano no debería poder ver el bando de un sheriff");
    }
}
