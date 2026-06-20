package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.roles.*;
import edu.fiuba.algo3.modelo.visitors.VisitanteDetective;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitanteDetectiveTest {
    private VisitanteDetective visitante;

    @BeforeEach
    public void arrange() {
        visitante = new VisitanteDetective();
    }

    @Test
    public void test01UnDetectiveVeAUnMafiosoComoMafioso() {
        // Act y Assert
        assertEquals(new Mafioso(), visitante.visitar(new Mafioso()),
                "Un detective debería ver a un mafioso como mafioso");
    }

    @Test
    public void test02UnDetectiveVeAUnPadrinoComoCiudadano() {
        // Act y Assert
        assertEquals(new Ciudadano(), visitante.visitar(new Padrino()),
                "Un detective debería ver a un padrino como ciudadano");
    }

    @Test
    public void test03UnDetectiveVeAUnCiudadanoComoCiudadano() {
        // Act y Assert
        assertEquals(new Ciudadano(), visitante.visitar(new Ciudadano()),
                "Un detective debería ver a un ciudadano como ciudadano");
    }

    @Test
    public void test04UnDetectiveVeAUnMedicoComoCiudadano() {
        // Act y Assert
        assertEquals(new Ciudadano(), visitante.visitar(new Medico()),
                "Un detective debería ver a un médico como ciudadano");
    }

    @Test
    public void test05UnDetectiveVeAUnDetectiveComoCiudadano() {
        // Act y Assert
        assertEquals(new Ciudadano(), visitante.visitar(new Detective()),
                "Un detective debería ver a otro detective como ciudadano");
    }

    @Test
    public void test06UnDetectiveVeAUnSheriffComoCiudadano() {
        // Act y Assert
        assertEquals(new Ciudadano(), visitante.visitar(new Sheriff()),
                "Un detective debería ver a un sheriff como ciudadano");
    }
}
